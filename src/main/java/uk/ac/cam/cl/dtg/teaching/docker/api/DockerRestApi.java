package uk.ac.cam.cl.dtg.teaching.docker.api;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import uk.ac.cam.cl.dtg.teaching.docker.model.Container;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerConfig;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerInfo;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerResponse;
import uk.ac.cam.cl.dtg.teaching.docker.model.ContainerStartConfig;
import uk.ac.cam.cl.dtg.teaching.docker.model.Image;
import uk.ac.cam.cl.dtg.teaching.docker.model.ImageInfo;
import uk.ac.cam.cl.dtg.teaching.docker.model.Version;
import uk.ac.cam.cl.dtg.teaching.docker.model.WaitResponse;

@Produces("application/json")
@Consumes("application/json") 
public interface DockerRestApi {

	@GET
	@Path("/version")
	public Version getVersion();
	
	@GET
	@Path("/containers/json")
	public List<Container> listContainers(@QueryParam("all") Boolean showAll,
			@QueryParam("limit") Integer maxResults,
			@QueryParam("since") String createdAfterId,
			@QueryParam("before") String createdBeforeId,
			@QueryParam("size") Boolean showSize);
	
	@POST
	@Path("/containers/create")
	public ContainerResponse createContainer(@QueryParam("name") String name, ContainerConfig config);
	
	@GET
	@Path("/containers/{id}/json")
	public ContainerInfo inspectContainer(@PathParam("id") String id, @QueryParam("size") Boolean showSize);


	/**
	 * Block until the container stops
	 * @param id of the container
	 * @return the container's exit code
	 */
	@POST
	@Path("/containers/{id}/wait")
	public WaitResponse waitContainer(@PathParam("id") String id);
	
	@DELETE
	@Path("/containers/{id}")
	public void deleteContainer(@PathParam("id") String id, @QueryParam("force") Boolean force, @QueryParam("v") Boolean removeVolumes);

	@POST
	@Path("/containers/{id}/start")
	public void startContainer(@PathParam("id") String id, ContainerStartConfig config);
	
	@POST
	@Path("/commit")
	public ContainerResponse commitContainer(@QueryParam("container") String sourceContainer,
			@QueryParam("repo") String targetImageRepo,
			@QueryParam("tag") String targetImageTag,
			@QueryParam("m") String commitMessage,
			@QueryParam("author") String author,
			ContainerConfig config);
	
	@GET
	@Path("/images/json")
	public List<Image> listImages(@QueryParam("all") Boolean showAll,
			@QueryParam("limit") Integer maxResults,
			@QueryParam("since") String createdAfterId,
			@QueryParam("before") String createdBeforeId,
			@QueryParam("size") Boolean showSize);

	@DELETE
	@Path("/images/{name}")
	public List<Map<String,String>> deleteImage(@PathParam("name") String id, @QueryParam("force") Boolean force, @QueryParam("noprune") Boolean noprune);

	@GET
	@Path("/images/{name}/json")
	public ImageInfo inspectImage(@PathParam("name") String id);

	/**
	 * Kill a container. 
	 * @param id of container to kill
	 * @param signal either a string (SIGKILL) or a number (9)
	 */
	@POST
	@Path("/containers/{id}/kill")
	public void killContainer(@PathParam("id") String id, @QueryParam("signal") String signal);
	
}


