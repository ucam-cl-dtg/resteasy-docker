package uk.ac.cam.cl.dtg.teaching.docker;

import java.io.File;
import java.util.List;

import uk.ac.cam.cl.dtg.teaching.docker.api.DockerApi;
import uk.ac.cam.cl.dtg.teaching.docker.model.Container;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerInfo;

public class DockerUtil {

	public static String bind(File host, File container) {
		return bind(host,container,false);
	}
	
	public static String bind(File host, File container, boolean readOnly) {
		return host.getPath()+":"+container.getPath()+(readOnly?":ro":"");
	}

	public static void deleteContainerByName(String name, DockerApi docker) {
		List<Container> containers = docker.listContainers(true, null, null, null, null);
		for(Container container : containers) {
			String[] names = container.getNames();
			if (names != null && names.length > 0 && names[0].equals("/"+name)) {
				docker.deleteContainer(container.getId(), true, true);
			}
		}
	}

	public static boolean waitRunning(String containerID, DockerApi docker) {
		for(int i=0;i<5;++i) {
			ContainerInfo info = docker.inspectContainer(containerID);
			if (info.getState().getPid() != 0) return true;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
