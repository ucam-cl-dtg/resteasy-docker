package uk.ac.cam.cl.dtg.teaching.docker.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainerInfo {

	@JsonProperty("AppArmorProfile")
	private String appArmorProfile;

	@JsonProperty("Args")
	private List<String> args;

	@JsonProperty("Config")
	private ContainerConfig config;

	@JsonProperty("Created")
	private String created;

	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("ExecDriver")
	private String execDriver;

	@JsonProperty("ExecIDs")
	private List<String> execIDs;

	@JsonProperty("HostConfig")
	private ContainerHostConfig hostConfig;

	@JsonProperty("HostnamePath")
	private String hostnamePath;
	
	@JsonProperty("HostsPath")
	private String hostsPath;

	@JsonProperty("LogPath")
	private String logPath;
		
	@JsonProperty("Id")
	private String id;
	
	@JsonProperty("Image")
	private String image;
	
	@JsonProperty("MountLabel")
	private String mountLabel;
	
	@JsonProperty("Name")
	private String name;

	@JsonProperty("NetworkSettings")
	private ContainerNetworkSettings networkSettings;
	
	@JsonProperty("Path")
	private String path;
	
	@JsonProperty("ProcessLabel")
	private String processLabel;
	
	@JsonProperty("ResolvConfPath")
	private String resolvConfPath;

	@JsonProperty("RestartCount")
	private Integer restartCount;
		
	@JsonProperty("State")
	private ContainerState state;
	
	@JsonProperty("Mounts")
	private List<ContainerMount> mounts;

	@JsonProperty("GraphDriver")
	private Map<String,?> graphDriver;
	

	public Map<String, ?> getGraphDriver() {
		return graphDriver;
	}

	public void setGraphDriver(Map<String, ?> graphDriver) {
		this.graphDriver = graphDriver;
	}

	public String getAppArmorProfile() {
		return appArmorProfile;
	}

	public void setAppArmorProfile(String appArmorProfile) {
		this.appArmorProfile = appArmorProfile;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	public ContainerConfig getConfig() {
		return config;
	}

	public void setConfig(ContainerConfig config) {
		this.config = config;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getExecDriver() {
		return execDriver;
	}

	public void setExecDriver(String execDriver) {
		this.execDriver = execDriver;
	}

	public List<String> getExecIDs() {
		return execIDs;
	}

	public void setExecIDs(List<String> execIDs) {
		this.execIDs = execIDs;
	}

	public ContainerHostConfig getHostConfig() {
		return hostConfig;
	}

	public void setHostConfig(ContainerHostConfig hostConfig) {
		this.hostConfig = hostConfig;
	}

	public String getHostnamePath() {
		return hostnamePath;
	}

	public void setHostnamePath(String hostnamePath) {
		this.hostnamePath = hostnamePath;
	}

	public String getHostsPath() {
		return hostsPath;
	}

	public void setHostsPath(String hostsPath) {
		this.hostsPath = hostsPath;
	}

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMountLabel() {
		return mountLabel;
	}

	public void setMountLabel(String mountLabel) {
		this.mountLabel = mountLabel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ContainerNetworkSettings getNetworkSettings() {
		return networkSettings;
	}

	public void setNetworkSettings(ContainerNetworkSettings networkSettings) {
		this.networkSettings = networkSettings;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getProcessLabel() {
		return processLabel;
	}

	public void setProcessLabel(String processLabel) {
		this.processLabel = processLabel;
	}

	public String getResolvConfPath() {
		return resolvConfPath;
	}

	public void setResolvConfPath(String resolvConfPath) {
		this.resolvConfPath = resolvConfPath;
	}

	public Integer getRestartCount() {
		return restartCount;
	}

	public void setRestartCount(Integer restartCount) {
		this.restartCount = restartCount;
	}

	public ContainerState getState() {
		return state;
	}

	public void setState(ContainerState state) {
		this.state = state;
	}

	public List<ContainerMount> getMounts() {
		return mounts;
	}

	public void setMounts(List<ContainerMount> mounts) {
		this.mounts = mounts;
	}
	

	
}
