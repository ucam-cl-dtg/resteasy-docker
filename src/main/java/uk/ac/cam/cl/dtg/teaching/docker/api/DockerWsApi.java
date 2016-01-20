package uk.ac.cam.cl.dtg.teaching.docker.api;

import org.eclipse.jetty.websocket.api.WebSocketListener;

public interface DockerWsApi {
	public void attach(String containerId,boolean logs, boolean stream, boolean stdout, boolean stderr, boolean stdin, WebSocketListener listener);

}
