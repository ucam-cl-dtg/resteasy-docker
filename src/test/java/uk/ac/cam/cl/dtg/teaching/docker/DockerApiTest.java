package uk.ac.cam.cl.dtg.teaching.docker;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.ac.cam.cl.dtg.teaching.docker.api.DockerApi;
import uk.ac.cam.cl.dtg.teaching.docker.model.Container;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerConfig;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerInfo;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerResponse;
import uk.ac.cam.cl.dtg.teaching.docker.model.Image;
import uk.ac.cam.cl.dtg.teaching.docker.model.SystemInfo;

public class DockerApiTest {

  private DockerApi api;

  @Before
  public void connect() {
    Docker docker = new Docker("localhost", 2375, 10);
    api =
        docker.api(
            new ApiListener() {

              @Override
              public void callCompleted(boolean apiAvailable, long timeTaken, String methodName) {}
            });
  }

  @Test
  public void testSystemInfo() throws ApiUnavailableException {
    SystemInfo systemInfo = api.systemInfo();
  }

  @Test
  public void testAttach() throws InterruptedException {
    int num = 50;
    ExecutorService executor = Executors.newFixedThreadPool(num);
    for (int i = 0; i < num; i++) {
      final int j = i;
      executor.submit(
          new Callable<Void>() {
            @Override
            public Void call() throws Exception {
              String response =
                  DockerUtil.attachAndWait(
                      "read FOO; echo hello $FOO", j + "\n", "ubuntu:16.04", api);
              Assert.assertEquals("hello " + j, response.trim());
              return null;
            }
          });
    }
    executor.shutdown();
    if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
      Assert.fail("Timed out waiting for executor pool to finish.");
    }
  }

  @Test
  public void testVersion() throws ApiUnavailableException {
    api.getVersion();
  }

  @Test
  public void testCreateDeleteContainer() throws IOException, ApiUnavailableException {
    try (CreatedContainer c = createContainer()) {}
  }

  @Test
  public void testListContainers() throws IOException, ApiUnavailableException {
    boolean found = false;
    try (CreatedContainer created = createContainer()) {
      List<Container> containers = api.listContainers(true, null, null, null, null);
      for (Container c : containers) {
        if (c.getId().equals(created.getId())) found = true;
      }
    }
    Assert.assertTrue("Created container but failed to find it in result of listContainers", found);
  }

  @Test
  public void testStartContainer() throws IOException, ApiUnavailableException {
    try (CreatedContainer created = createContainer()) {
      api.startContainer(created.getId());
    }
  }

  @Test
  public void testInspectContainer() throws IOException, ApiUnavailableException {
    try (CreatedContainer created = createContainer()) {
      ContainerInfo info = api.inspectContainer(created.getId(), null);
      Assert.assertEquals(
          "Name of inspected container should match name of created container",
          "/" + created.getName(),
          info.getName());
    }
  }

  @Test
  public void testCommitContainer() throws IOException, ApiUnavailableException {
    try (CreatedContainer created = createContainer()) {
      try (CreatedImage image = commitContainer(created)) {}
    }
  }

  @Test
  public void testListImages() throws IOException, ApiUnavailableException {
    boolean found = false;
    try (CreatedContainer created = createContainer()) {
      try (CreatedImage image = commitContainer(created)) {
        List<Image> images = api.listImages(true, null, null, null, null);
        for (Image i : images) {
          if (i.getId().equals(image.getId())) found = true;
        }
      }
    }
    Assert.assertTrue("Created image but failed to find it in result of listImages", found);
  }

  @Test
  public void testInspectImage() throws IOException, ApiUnavailableException {
    try (CreatedContainer created = createContainer()) {
      try (CreatedImage image = commitContainer(created)) {
        api.inspectImage(image.getId());
      }
    }
  }

  private CreatedImage commitContainer(CreatedContainer created) throws ApiUnavailableException {
    String tag = UUID.randomUUID().toString();
    ContainerConfig config = new ContainerConfig();
    return new CreatedImage(
        api.commitContainer(created.getId(), "unittest", tag, null, null, config));
  }

  private CreatedContainer createContainer() throws ApiUnavailableException {
    String name = UUID.randomUUID().toString();
    ContainerConfig config = new ContainerConfig();
    config.setCmd(Arrays.asList("/bin/echo", "hello"));
    config.setImage("ubuntu:16.04");
    return new CreatedContainer(name, api.createContainer(name, config));
  }

  private class CreatedImage implements Closeable {
    private String id;

    public CreatedImage(ContainerResponse r) {
      this.id = r.getId();
    }

    public String getId() {
      return id;
    }

    @Override
    public void close() throws IOException {
      try {
        api.deleteImage(id, true, false);
      } catch (ApiUnavailableException e) {
        throw new IOException(e);
      }
    }
  }

  private class CreatedContainer implements Closeable {
    private String id;
    private String name;

    public CreatedContainer(String name, ContainerResponse r) {
      this.name = name;
      this.id = r.getId();
    }

    public String getName() {
      return name;
    }

    public String getId() {
      return id;
    }

    @Override
    public void close() throws IOException {
      try {
        api.deleteContainer(id, true, true);
      } catch (ApiUnavailableException e) {
        throw new IOException(e);
      }
    }
  }
}
