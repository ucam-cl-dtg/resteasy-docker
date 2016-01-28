package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Version {

	@JsonProperty("Version")
	private String version;

	@JsonProperty("Os")
	private String os;
	
	@JsonProperty("KernelVersion")
	private String kernelVersion;

	@JsonProperty("GoVersion")
	private String goVersion;

	@JsonProperty("GitCommit")
	private String gitCommit;

	@JsonProperty("Arch")
	private String arch;
		
	@JsonProperty("ApiVersion")
	private String apiVersion;
	
	@JsonProperty("Experimental")
	private boolean experimental;

	@JsonProperty("BuildTime")
	private String buildTime;
	
	
	
	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public boolean isExperimental() {
		return experimental;
	}

	public void setExperimental(boolean experimental) {
		this.experimental = experimental;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getKernelVersion() {
		return kernelVersion;
	}

	public void setKernelVersion(String kernelVersion) {
		this.kernelVersion = kernelVersion;
	}

	public String getArch() {
		return arch;
	}

	public void setArch(String arch) {
		this.arch = arch;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getGitCommit() {
		return gitCommit;
	}

	public void setGitCommit(String gitCommit) {
		this.gitCommit = gitCommit;
	}

	public String getGoVersion() {
		return goVersion;
	}

	public void setGoVersion(String goVersion) {
		this.goVersion = goVersion;
	}
	
	
	
}
