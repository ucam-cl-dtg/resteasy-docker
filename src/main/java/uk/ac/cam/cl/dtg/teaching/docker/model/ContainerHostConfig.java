package uk.ac.cam.cl.dtg.teaching.docker.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainerHostConfig {

	@JsonProperty("Binds")
	private String[] binds;
	
	@JsonProperty("ContainerIDFile")
	private String containerIDFile;
	
	@JsonProperty("LxcConf")
	private String[] lxcConf;
	
	@JsonProperty("Privileged")
	private Boolean privileged;
	
	@JsonProperty("PortBindings")
	private Map<String,?> portBindings;
	
	@JsonProperty("Links")
	private String links;
	
	@JsonProperty("PublishAllPorts")
	private Boolean publishAllPorts;
	
	@JsonProperty("Dns")
	private String dns;
	
	@JsonProperty("DnsSearch")
	private String dnsSearch;
	
	@JsonProperty("VolumesFrom")
	private String volumesFrom = "";
	
	@JsonProperty("NetworkMode")
	private String networkMode;
	
	@JsonProperty("CapAdd")
	private String capAdd;
	
	@JsonProperty("CapDrop")
	private String capDrop;
	
	@JsonProperty("CgroupParent")
	private String cgroupParent;
	
	@JsonProperty("CpuShares")
	private Integer cpuShares;
	
	@JsonProperty("CpusetCpus")
	private String cpusetCpus;
	
	@JsonProperty("Devices")
	private List<String> devices;
	
	@JsonProperty("ExtraHosts")
	private String extraHosts;
	
	@JsonProperty("IpcMode")
	private String ipcMode;
	
	@JsonProperty("LogConfig")
	private LogConfig logConfig;

	@JsonProperty("Memory")
	private Integer memory;
	
	@JsonProperty("MemorySwap")
	private Integer memorySwap;
	
	@JsonProperty("PidMode")
	private String pidMode;
	
	@JsonProperty("ReadonlyRootfs")
	private Boolean readonlyRootfs;
	
	@JsonProperty("RestartPolicy")
	private RestartPolicy restartPolicy;
	
	@JsonProperty("SecurityOpt")
	private String securityOpt;
	
	@JsonProperty("Ulimits")
	private Map<String,String> ulimits;
	
	
	
	
	public String getNetworkMode() {
		return networkMode;
	}

	public void setNetworkMode(String networkMode) {
		this.networkMode = networkMode;
	}

	public String getVolumesFrom() {
		return volumesFrom;
	}

	public void setVolumesFrom(String volumesFrom) {
		this.volumesFrom = volumesFrom;
	}

	public String getDnsSearch() {
		return dnsSearch;
	}

	public void setDnsSearch(String dnsSearch) {
		this.dnsSearch = dnsSearch;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}

	public String[] getBinds() {
		return binds;
	}

	public void setBinds(String[] binds) {
		this.binds = binds;
	}

	public String getContainerIDFile() {
		return containerIDFile;
	}

	public void setContainerIDFile(String containerIDFile) {
		this.containerIDFile = containerIDFile;
	}

	public String[] getLxcConf() {
		return lxcConf;
	}

	public void setLxcConf(String[] lxcConf) {
		this.lxcConf = lxcConf;
	}

	public Boolean getPrivileged() {
		return privileged;
	}

	public void setPrivileged(Boolean privileged) {
		this.privileged = privileged;
	}

	public Map<String, ?> getPortBindings() {
		return portBindings;
	}

	public void setPortBindings(Map<String, ?> portBindings) {
		this.portBindings = portBindings;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public Boolean getPublishAllPorts() {
		return publishAllPorts;
	}

	public void setPublishAllPorts(Boolean publishAllPorts) {
		this.publishAllPorts = publishAllPorts;
	}

	public String getCapAdd() {
		return capAdd;
	}

	public void setCapAdd(String capAdd) {
		this.capAdd = capAdd;
	}

	public String getCapDrop() {
		return capDrop;
	}

	public void setCapDrop(String capDrop) {
		this.capDrop = capDrop;
	}

	public String getCgroupParent() {
		return cgroupParent;
	}

	public void setCgroupParent(String cgroupParent) {
		this.cgroupParent = cgroupParent;
	}

	public Integer getCpuShares() {
		return cpuShares;
	}

	public void setCpuShares(Integer cpuShares) {
		this.cpuShares = cpuShares;
	}

	public String getCpusetCpus() {
		return cpusetCpus;
	}

	public void setCpusetCpus(String cpusetCpus) {
		this.cpusetCpus = cpusetCpus;
	}

	public List<String> getDevices() {
		return devices;
	}

	public void setDevices(List<String> devices) {
		this.devices = devices;
	}

	public String getExtraHosts() {
		return extraHosts;
	}

	public void setExtraHosts(String extraHosts) {
		this.extraHosts = extraHosts;
	}

	public String getIpcMode() {
		return ipcMode;
	}

	public void setIpcMode(String ipcMode) {
		this.ipcMode = ipcMode;
	}

	public LogConfig getLogConfig() {
		return logConfig;
	}

	public void setLogConfig(LogConfig logConfig) {
		this.logConfig = logConfig;
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

	public String getPidMode() {
		return pidMode;
	}

	public void setPidMode(String pidMode) {
		this.pidMode = pidMode;
	}

	public Boolean getReadonlyRootfs() {
		return readonlyRootfs;
	}

	public void setReadonlyRootfs(Boolean readonlyRootfs) {
		this.readonlyRootfs = readonlyRootfs;
	}

	public RestartPolicy getRestartPolicy() {
		return restartPolicy;
	}

	public void setRestartPolicy(RestartPolicy restartPolicy) {
		this.restartPolicy = restartPolicy;
	}

	public String getSecurityOpt() {
		return securityOpt;
	}

	public void setSecurityOpt(String securityOpt) {
		this.securityOpt = securityOpt;
	}

	public Map<String, String> getUlimits() {
		return ulimits;
	}

	public void setUlimits(Map<String, String> ulimits) {
		this.ulimits = ulimits;
	}

	
	
}