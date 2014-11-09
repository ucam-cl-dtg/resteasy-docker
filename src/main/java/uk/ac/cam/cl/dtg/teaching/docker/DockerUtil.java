package uk.ac.cam.cl.dtg.teaching.docker;

import java.io.File;

public class DockerUtil {

	public static String bind(File host, File container) {
		return bind(host,container,false);
	}
	
	public static String bind(File host, File container, boolean readOnly) {
		return host.getPath()+":"+container.getPath()+(readOnly?":ro":"");
	}
	
}
