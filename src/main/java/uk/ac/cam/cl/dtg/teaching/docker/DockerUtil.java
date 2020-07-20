package uk.ac.cam.cl.dtg.teaching.docker;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;
import uk.ac.cam.cl.dtg.teaching.docker.api.DockerApi;
import uk.ac.cam.cl.dtg.teaching.docker.model.Container;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerConfig;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerInfo;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerResponse;

/** Utility methods for interacting with the API. */
public class DockerUtil {

  public static String bind(File host, File container) {
    return bind(host, container, false);
  }

  public static String bind(File host, File container, boolean readOnly) {
    return host.getPath() + ":" + container.getPath() + (readOnly ? ":ro" : "");
  }

  /**
   * Attempt to delete the container with the specified name (rather than by ID).
   *
   * @param name the name (not the Id) of the container to delete
   * @param docker connection to the Docker API
   * @throws ApiUnavailableException if the docker API is not contactable
   */
  public static void deleteContainerByName(String name, DockerApi docker)
      throws ApiUnavailableException {
    List<Container> containers = docker.listContainers(true, null, null, null, null);
    for (Container container : containers) {
      String[] names = container.getNames();
      if (names != null && names.length > 0 && names[0].equals("/" + name)) {
        DockerPatch.deleteContainer(docker, container.getId(), true, true);
      }
    }
  }

  /**
   * Wait until a container is running.
   *
   * @param containerId the Id of the container
   * @param docker connection to the docker API
   * @return true if we managed to wait for the container to stop
   * @throws ApiUnavailableException if the docker API is not contactable
   */
  public static boolean waitRunning(String containerId, DockerApi docker)
      throws ApiUnavailableException {
    try {
      for (int i = 0; i < 5; ++i) {
        ContainerInfo info = docker.inspectContainer(containerId, null);
        if (info.getState().getPid() != 0) {
          return true;
        }
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      // ignore
    }
    return false;
  }

  /**
   * Kill a container.
   *
   * @param containerId the Id of the container
   * @param docker connection to the docker API
   * @return true if we killed the container
   * @throws ApiUnavailableException if the docker API is not contactable
   */
  public static boolean killContainer(String containerId, DockerApi docker)
      throws ApiUnavailableException {
    try {
      docker.killContainer(containerId, "SIGKILL");
      return true;
    } catch (RuntimeException e) {
      if (e.getMessage().contains("is not running")) {
        return false;
      } else if (e.getMessage().contains("No such container")) {
        return false;
      } else {
        throw e;
      }
    }
  }

  /**
   * Inspect a container.
   *
   * @param containerId the Id of the container
   * @param showSize include the size in the response
   * @param docker connection to the docker API
   * @return a ContainerInfo object populated for this container
   * @throws ApiUnavailableException if the docker API is not contactable
   */
  public static ContainerInfo inspectContainer(
      String containerId, Boolean showSize, DockerApi docker) throws ApiUnavailableException {
    try {
      return docker.inspectContainer(containerId, showSize);
    } catch (RuntimeException e) {
      if (e.getMessage().equals("No such container: " + containerId)) {
        return null;
      }
      throw e;
    }
  }

  /**
   * Creates a container with the specified command, waits for it to finish and returns the output.
   *
   * @param cmd the command to run in the container
   * @param stdin text to write to the container's standard input
   * @param image name of the image to use for the container
   * @param docker connection to the docker API
   * @return the output of the container
   * @throws ApiUnavailableException if the docker API is not contactable
   */
  public static String attachAndWait(String cmd, String stdin, String image, DockerApi docker)
      throws ApiUnavailableException {
    String name = UUID.randomUUID().toString();
    ContainerConfig config = new ContainerConfig();
    config.setOpenStdin(true);
    config.setCmd(Arrays.asList("/bin/bash", "-c", cmd));
    config.setImage(image);
    StringBuffer output = new StringBuffer();
    ContainerResponse createResponse = docker.createContainer(name, config);
    try {
      docker.startContainer(createResponse.getId());
      AttachListener l = new AttachListener(output, stdin);
      docker.attach(createResponse.getId(), true, true, true, true, true, l);
      docker.waitContainer(createResponse.getId());
    } finally {
      DockerPatch.deleteContainer(docker, createResponse.getId(), true, true);
    }
    return output.toString();
  }

  private static class AttachListener implements WebSocketListener {
    private StringBuffer output;
    private String data;

    AttachListener(StringBuffer output, String data) {
      this.output = output;
      this.data = data;
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {}

    @Override
    public void onWebSocketConnect(Session session) {
      try {
        session.getRemote().sendString(data);
      } catch (IOException e) {
        throw new RuntimeException("Failed to send input data to container", e);
      }
    }

    @Override
    public void onWebSocketError(Throwable cause) {
      throw new RuntimeException("WebSocket error attaching to container", cause);
    }

    @Override
    public void onWebSocketBinary(byte[] payload, int offset, int len) {
      output.append(new String(payload, offset, len));
    }

    @Override
    public void onWebSocketText(String message) {
      output.append(message);
    }
  }
}
