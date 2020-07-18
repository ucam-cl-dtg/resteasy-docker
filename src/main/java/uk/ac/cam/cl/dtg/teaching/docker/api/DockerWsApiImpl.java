package uk.ac.cam.cl.dtg.teaching.docker.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Future;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Implementation of the web service API interface. */
public class DockerWsApiImpl implements DockerWsApi {

  private static final Logger LOG = LoggerFactory.getLogger(DockerWsApiImpl.class);

  private String hostname;
  private int port;
  private WebSocketClient client;

  /** Constructs a new instance which attempts to connect to the given hostname and port. */
  public DockerWsApiImpl(String hostname, int port) {
    this.hostname = hostname;
    this.port = port;
    client = new WebSocketClient();
    try {
      client.start();
    } catch (Exception e) {
      LOG.error("Failed to start WebSocketClient", e);
      throw new Error(e);
    }
  }

  /** Attempt to shutdown and tidy up. */
  public void close() {
    try {
      client.stop();
    } catch (Exception e) {
      LOG.error("Failed to stop WebSocketClient", e);
    }
  }

  @Override
  public Future<Session> attach(
      final String containerId,
      final boolean logs,
      final boolean stream,
      final boolean stdout,
      final boolean stderr,
      final boolean stdin,
      final WebSocketListener listener) {
    String url =
        String.format(
            "ws://%s:%d/containers/%s/attach/ws?logs=%s&stream=%s&stdout=%s&stderr=%s&stdin=%s",
            hostname,
            port,
            containerId,
            logs ? "1" : "0",
            stream ? "1" : "0",
            stdout ? "1" : "0",
            stderr ? "1" : "0",
            stdin ? "1" : "0");
    try {
      URI uri = new URI(url);
      ClientUpgradeRequest req = new ClientUpgradeRequest();
      req.setHeader(
          "origin", "http://localhost:2375"); // this can be anything - but it has to be there....
      return client.connect(listener, uri, req);
    } catch (URISyntaxException e) {
      throw new RuntimeException("Failed to connect to web socket", e);
    } catch (IOException e) {
      throw new RuntimeException("Failed to connect to web socket", e);
    }
  }
}
