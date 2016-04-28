package uk.ac.cam.cl.dtg.teaching.docker.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageInfo {

		@JsonProperty("Id")
		private String id;

		@JsonProperty("Container")
		private String container;
		
		@JsonProperty("Comment")
		private String comment;
		
		@JsonProperty("Os")
		private String os;
		
		@JsonProperty("Architecture")
		private String architecture;

		@JsonProperty("Parent")
		private String parent;

		@JsonProperty("ContainerConfig")
		private ContainerConfig containerConfig;

		@JsonProperty("DockerVersion")
		private String dockerVersion;

		@JsonProperty("VirtualSize")
		private Long virtualSize;
		
		@JsonProperty("Size")
		private Long size;

		@JsonProperty("Author")
		private String author;

		@JsonProperty("Created")
		private String created;
		
		@JsonProperty("GraphDriver")
		private Map<String,String> graphDriver;
		
		@JsonProperty("RepoDigests")
		private List<String> repoDigests;
				
		@JsonProperty("RepoTags")
		private List<String> repoTags;
		
		@JsonProperty("Config")
		private ContainerConfig config;

		@JsonProperty("RootFS")
		private RootFS rootFS;
			
		
		public RootFS getRootFS() {
			return rootFS;
		}

		public void setRootFS(RootFS rootFS) {
			this.rootFS = rootFS;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getContainer() {
			return container;
		}

		public void setContainer(String container) {
			this.container = container;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getOs() {
			return os;
		}

		public void setOs(String os) {
			this.os = os;
		}

		public String getArchitecture() {
			return architecture;
		}

		public void setArchitecture(String architecture) {
			this.architecture = architecture;
		}

		public String getParent() {
			return parent;
		}

		public void setParent(String parent) {
			this.parent = parent;
		}

		public ContainerConfig getContainerConfig() {
			return containerConfig;
		}

		public void setContainerConfig(ContainerConfig containerConfig) {
			this.containerConfig = containerConfig;
		}

		public String getDockerVersion() {
			return dockerVersion;
		}

		public void setDockerVersion(String dockerVersion) {
			this.dockerVersion = dockerVersion;
		}

		public Long getVirtualSize() {
			return virtualSize;
		}

		public void setVirtualSize(Long virtualSize) {
			this.virtualSize = virtualSize;
		}

		public Long getSize() {
			return size;
		}

		public void setSize(Long size) {
			this.size = size;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getCreated() {
			return created;
		}

		public void setCreated(String created) {
			this.created = created;
		}

		public Map<String, String> getGraphDriver() {
			return graphDriver;
		}

		public void setGraphDriver(Map<String, String> graphDriver) {
			this.graphDriver = graphDriver;
		}

		public List<String> getRepoDigests() {
			return repoDigests;
		}

		public void setRepoDigests(List<String> repoDigests) {
			this.repoDigests = repoDigests;
		}

		public List<String> getRepoTags() {
			return repoTags;
		}

		public void setRepoTags(List<String> repoTags) {
			this.repoTags = repoTags;
		}

		public ContainerConfig getConfig() {
			return config;
		}

		public void setConfig(ContainerConfig config) {
			this.config = config;
		}
		
}
