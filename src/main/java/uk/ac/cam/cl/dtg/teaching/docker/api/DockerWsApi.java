package uk.ac.cam.cl.dtg.teaching.docker.api;

import java.util.concurrent.Future;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;

public interface DockerWsApi {
	public Future<Session> attach(String containerId,boolean logs, boolean stream, boolean stdout, boolean stderr, boolean stdin, WebSocketListener listener);

	public void close();
	
}
