package uk.ac.cam.cl.dtg.teaching.docker;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.ac.cam.cl.dtg.teaching.docker.api.DockerApi;
import uk.ac.cam.cl.dtg.teaching.docker.model.Container;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerConfig;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerInfo;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerResponse;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerStartConfig;
import uk.ac.cam.cl.dtg.teaching.docker.model.Image;

public class DockerApiTest {

	private DockerApi api;
	
	@Before
	public void connect() {
		Docker docker = new Docker("localhost",2375);
		api = docker.api();
	}
	
	@Test
	public void testVersion() {		
		api.getVersion();
	}

	@Test
	public void testCreateDeleteContainer() throws IOException {
		try (CreatedContainer c = createContainer()) {}
	}
	
	@Test
	public void testListContainers() throws IOException {
		boolean found = false;
		try( CreatedContainer created = createContainer()) {
			List<Container> containers = api.listContainers(true, null, null, null, null);
			for (Container c : containers) {
				if (c.getId().equals(created.getId())) 
					found = true;
			}
		}
		Assert.assertTrue("Created container but failed to find it in result of listContainers",found);
	}
	
	@Test
	public void testStartContainer() throws IOException {
		try (CreatedContainer created = createContainer()) {
			ContainerStartConfig config = new ContainerStartConfig();
			api.startContainer(created.getId(), config);
		}
	}
	
	@Test
	public void testInspectContainer() throws IOException {
		try (CreatedContainer created = createContainer()) {
				ContainerInfo info = api.inspectContainer(created.getId());
				Assert.assertEquals("Name of inspected container should match name of created container", "/"+created.getName(), info.getName());
		}
	}
	
	@Test
	public void testCommitContainer() throws IOException {
		try (CreatedContainer created = createContainer()) {
			try (CreatedImage image = commitContainer(created)) {}
		}
	}
	
	@Test
	public void testListImages() throws IOException {
		boolean found = false;
		try (CreatedContainer created = createContainer()) {
			try (CreatedImage image = commitContainer(created)) {
				List<Image> images = api.listImages(true, null, null, null, null);
				for (Image i : images) {
					if (i.getId().equals(image.getId())) 
						found = true;
				}
			}
		}
		Assert.assertTrue("Created image but failed to find it in result of listImages",found);
	}
	
	@Test
	public void testInspectImage() throws IOException {
		try (CreatedContainer created = createContainer()) {
			try (CreatedImage image = commitContainer(created)) {
				api.inspectImage(image.getId());				
			}	
		}
	}
	
	private CreatedImage commitContainer(CreatedContainer created) {
		String tag = UUID.randomUUID().toString();
		ContainerConfig config = new ContainerConfig();
		return new CreatedImage(api.commitContainer(created.getId(), "unittest", tag, null, null, config));
		
	}
	
	private CreatedContainer createContainer() {
		String name = UUID.randomUUID().toString();
		ContainerConfig config = new ContainerConfig();
		config.setCmd(new String[] { "/bin/echo","hello" });
		config.setImage("ubuntu:14.04");
		return new CreatedContainer(name,api.createContainer(name, config));
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
			api.deleteImage(id,true,false);
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
			api.deleteContainer(id,true,true);
		}
		
	}
}
