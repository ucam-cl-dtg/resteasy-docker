package uk.ac.cam.cl.dtg.teaching.docker.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainerConfig {

	@JsonProperty("Hostname")
	private String hostname = "";
	
	@JsonProperty("Domainname")
	private String domainname = "";
	
	@JsonProperty("User")
	private String user = "";

	@JsonProperty("Memory")
	private Integer memory;

	@JsonProperty("MemorySwap")
	private Integer memorySwap;
	
	@JsonProperty("CpuShares")
	private Integer cpuShares;
	
	/**
	 * Comma separated list of CPUs (by number) on which this guest is allowed to run.  Use an empty string for no restriction.  
	 */
	@JsonProperty("Cpuset")
	private String cpuset = "";
	
	@JsonProperty("AttachStdin")
	private Boolean attachStdin;
	
	@JsonProperty("AttachStdout")
	private Boolean attachStdout;
	
	@JsonProperty("AttachStderr")
	private Boolean attachStderr;
	
	@JsonProperty("Tty")
	private Boolean tty;
	
	@JsonProperty("OpenStdin")
	private Boolean openStdin;
		
	@JsonProperty("StdinOnce")
	private Boolean stdinOnce;
	
	@JsonProperty("Env")
	private List<String> env;
	
	@JsonProperty("Cmd")
	private String[] cmd;
	
	@JsonProperty("Image")
	private String image;
	
	@JsonProperty("Volumes")
	private Map<String,Map<String,String>> volumes;
	
	@JsonProperty("VolumesFrom")
	private String volumesFrom = "";
	
	@JsonProperty("WorkingDir")
	private String workingDir = "";
	
	@JsonProperty("NetworkDisabled")
	private Boolean networkDisabled;

	@JsonProperty("Entrypoint")
	private String entryPoint;
	
	@JsonProperty("PortSpecs")
	private String portSpecs;
	
	@JsonProperty("ExposedPorts")
	private Map<String,?> exposedPorts;
	
	@JsonProperty("Dns")
	private String dns;

	@JsonProperty("OnBuild")
	private String onBuild;
	
	@JsonProperty("MacAddress")
	private String macAddress;

	/**
	 * Custom metadata which you can add to a container.  Stored as key/value pairs
	 */
	@JsonProperty("Labels")
	private Map<String,String> labels;
	
	public String getCpuset() {
		return cpuset;
	}

	public void setCpuset(String cpuset) {
		this.cpuset = cpuset;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getDomainname() {
		return domainname;
	}

	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getMemory() {
		return memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	public Integer getMemorySwap() {
		return memorySwap;
	}

	public void setMemorySwap(Integer memorySwap) {
		this.memorySwap = memorySwap;
	}

	public Integer getCpuShares() {
		return cpuShares;
	}

	public void setCpuShares(Integer cpuShares) {
		this.cpuShares = cpuShares;
	}

	public Boolean getAttachStdin() {
		return attachStdin;
	}

	public void setAttachStdin(Boolean attachStdin) {
		this.attachStdin = attachStdin;
	}

	public Boolean getAttachStdout() {
		return attachStdout;
	}

	public void setAttachStdout(Boolean attachStdout) {
		this.attachStdout = attachStdout;
	}

	public Boolean getAttachStderr() {
		return attachStderr;
	}

	public void setAttachStderr(Boolean attachStderr) {
		this.attachStderr = attachStderr;
	}

	public Boolean getTty() {
		return tty;
	}

	public void setTty(Boolean tty) {
		this.tty = tty;
	}

	public Boolean getOpenStdin() {
		return openStdin;
	}

	public void setOpenStdin(Boolean openStdin) {
		this.openStdin = openStdin;
	}

	public Boolean getStdinOnce() {
		return stdinOnce;
	}

	public void setStdinOnce(Boolean stdinOnce) {
		this.stdinOnce = stdinOnce;
	}

	public List<String> getEnv() {
		return env;
	}

	public void setEnv(List<String> env) {
		this.env = env;
	}

	public String[] getCmd() {
		return cmd;
	}

	public void setCmd(String[] cmd) {
		this.cmd = cmd;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Map<String, Map<String, String>> getVolumes() {
		return volumes;
	}

	public void setVolumes(Map<String, Map<String, String>> volumes) {
		this.volumes = volumes;
	}

	public String getVolumesFrom() {
		return volumesFrom;
	}

	public void setVolumesFrom(String volumesFrom) {
		this.volumesFrom = volumesFrom;
	}

	public String getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(String workingDir) {
		this.workingDir = workingDir;
	}

	public Boolean getNetworkDisabled() {
		return networkDisabled;
	}

	public void setNetworkDisabled(Boolean networkDisabled) {
		this.networkDisabled = networkDisabled;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public String getPortSpecs() {
		return portSpecs;
	}

	public void setPortSpecs(String portSpecs) {
		this.portSpecs = portSpecs;
	}

	public Map<String, ?> getExposedPorts() {
		return exposedPorts;
	}

	public void setExposedPorts(Map<String, ?> exposedPorts) {
		this.exposedPorts = exposedPorts;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}

	public String getOnBuild() {
		return onBuild;
	}

	public void setOnBuild(String onBuild) {
		this.onBuild = onBuild;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	
}