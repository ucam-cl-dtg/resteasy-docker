package uk.ac.cam.cl.dtg.teaching.docker;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
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
import uk.ac.cam.cl.dtg.teaching.docker.model.Image;

public class DockerApiTest {

	private DockerApi api;
	
	@Before
	public void connect() {
		Docker docker = new Docker("localhost",2375,10);
		api = docker.api(new APIListener() {
			
			@Override
			public void callCompleted(boolean apiAvailable, long timeTaken, String methodName) {
			}
		});
	}
	
	@Test
	public void testAttach() {
		int num = 50;
		Thread[] t = new Thread[num];
		for(int i=0;i<num;i++) {
			final int j = i;
			t[i] = new Thread() {
				@Override
				public void run() {
					try {
						String response = DockerUtil.attachAndWait("read FOO; echo hello $FOO", j+"\n", "ubuntu:16.04",api);
						Assert.assertEquals("hello "+j, response.trim());
					} catch (Exception e) {
						throw new Error(e);
					}
				}
			};
			t[i].start();
		}
		try {
			for(int i=0;i<num;i++) {
				t[i].join();
			}
		} catch (InterruptedException e) {}
	}
	
	@Test
	public void testVersion() throws APIUnavailableException {		
		api.getVersion();
	}

	@Test
	public void testCreateDeleteContainer() throws IOException, APIUnavailableException {
		try (CreatedContainer c = createContainer()) {}
	}
	
	@Test
	public void testListContainers() throws IOException, APIUnavailableException {
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
	public void testStartContainer() throws IOException, APIUnavailableException {
		try (CreatedContainer created = createContainer()) {
			api.startContainer(created.getId());
		}
	}
	
	@Test
	public void testInspectContainer() throws IOException, APIUnavailableException {
		try (CreatedContainer created = createContainer()) {
				ContainerInfo info = api.inspectContainer(created.getId(), null);
				Assert.assertEquals("Name of inspected container should match name of created container", "/"+created.getName(), info.getName());
		}
	}
	
	@Test
	public void testCommitContainer() throws IOException, APIUnavailableException {
		try (CreatedContainer created = createContainer()) {
			try (CreatedImage image = commitContainer(created)) {}
		}
	}
	
	@Test
	public void testListImages() throws IOException, APIUnavailableException {
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
	public void testInspectImage() throws IOException, APIUnavailableException {
		try (CreatedContainer created = createContainer()) {
			try (CreatedImage image = commitContainer(created)) {
				api.inspectImage(image.getId());				
			}	
		}
	}
	
	private CreatedImage commitContainer(CreatedContainer created) throws APIUnavailableException {
		String tag = UUID.randomUUID().toString();
		ContainerConfig config = new ContainerConfig();
		return new CreatedImage(api.commitContainer(created.getId(), "unittest", tag, null, null, config));
		
	}
	
	private CreatedContainer createContainer() throws APIUnavailableException {
		String name = UUID.randomUUID().toString();
		ContainerConfig config = new ContainerConfig();
		config.setCmd(Arrays.asList("/bin/echo","hello"));
		config.setImage("ubuntu:16.04");
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
			try {
				api.deleteImage(id,true,false);
			} catch (APIUnavailableException e) {
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
				api.deleteContainer(id,true,true);
			} catch (APIUnavailableException e) {
				throw new IOException(e);
			}
		}
		
	}
}
