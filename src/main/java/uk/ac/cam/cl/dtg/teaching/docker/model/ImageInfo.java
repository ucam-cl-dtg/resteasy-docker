package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageInfo {

		private String id;
		
		private String parent;
		
		private String container;
		
		@JsonProperty("container_config")
		private ContainerConfig containerConfig;
		
		@JsonProperty("docker_version")
		private String dockerVersion;
		
		private String author;
		
		// same info as container_config?
		private ContainerConfig config;
		
		private String architecture;
		
		private String os;
		
		private String created;
		
		@JsonProperty("Size")
		private Long size;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getParent() {
			return parent;
		}

		public void setParent(String parent) {
			this.parent = parent;
		}

		public String getContainer() {
			return container;
		}

		public void setContainer(String container) {
			this.container = container;
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

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public ContainerConfig getConfig() {
			return config;
		}

		public void setConfig(ContainerConfig config) {
			this.config = config;
		}

		public String getArchitecture() {
			return architecture;
		}

		public void setArchitecture(String architecture) {
			this.architecture = architecture;
		}

		public String getOs() {
			return os;
		}

		public void setOs(String os) {
			this.os = os;
		}

		public String getCreated() {
			return created;
		}

		public void setCreated(String created) {
			this.created = created;
		}

		public Long getSize() {
			return size;
		}

		public void setSize(Long size) {
			this.size = size;
		}

		
}
