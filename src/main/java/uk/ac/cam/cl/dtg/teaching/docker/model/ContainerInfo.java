package uk.ac.cam.cl.dtg.teaching.docker.model;

import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainerInfo {

	@JsonProperty("ID")
	private String id;
	
	@JsonProperty("Created")
	private String created;
	
	@JsonProperty("Path")
	private String path;
	
	@JsonProperty("Args")
	private String[] args;
	
	@JsonProperty("Config")
	private ContainerConfig config;
	
	@JsonProperty("State")
	private ContainerState state;
	
	@JsonProperty("Image")
	private String image;
	
	@JsonProperty("NetworkSettings")
	private ContainerNetworkSettings networkSettings;
	
	@JsonProperty("ResolvConfPath")
	private String resolvConfPath;
	
	@JsonProperty("HostnamePath")
	private String hostnamePath;
	
	@JsonProperty("HostsPath")
	private String hostsPath;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Driver")
	private String driver;
	
	@JsonProperty("ExecDriver")
	private String execDriver;
	
	@JsonProperty("Volumes")
	private Map<String,String> volumes;
	
	@JsonProperty("VolumesRW")
	private Map<String,?> volumesRW;
	
	@JsonProperty("HostConfig")
	private ContainerHostConfig hostConfig;

	@JsonProperty("MountLabel")
	private String mountLabel;
	
	@JsonProperty("ProcessLabel")
	private String processLabel;
	
	
	
	public String getProcessLabel() {
		return processLabel;
	}

	public void setProcessLabel(String processLabel) {
		this.processLabel = processLabel;
	}

	public String getMountLabel() {
		return mountLabel;
	}

	public void setMountLabel(String mountLabel) {
		this.mountLabel = mountLabel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	public ContainerConfig getConfig() {
		return config;
	}

	public void setConfig(ContainerConfig config) {
		this.config = config;
	}

	public ContainerState getState() {
		return state;
	}

	public void setState(ContainerState state) {
		this.state = state;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ContainerNetworkSettings getNetworkSettings() {
		return networkSettings;
	}

	public void setNetworkSettings(ContainerNetworkSettings networkSettings) {
		this.networkSettings = networkSettings;
	}

	public String getResolvConfPath() {
		return resolvConfPath;
	}

	public void setResolvConfPath(String resolvConfPath) {
		this.resolvConfPath = resolvConfPath;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Map<String, String> getVolumes() {
		return volumes;
	}

	public void setVolumes(Map<String, String> volumes) {
		this.volumes = volumes;
	}

	public Map<String, ?> getVolumesRW() {
		return volumesRW;
	}

	public void setVolumesRW(Map<String, ?> volumesRW) {
		this.volumesRW = volumesRW;
	}

	public ContainerHostConfig getHostConfig() {
		return hostConfig;
	}

	public void setHostConfig(ContainerHostConfig hostConfig) {
		this.hostConfig = hostConfig;
	}

	@Override
	public String toString() {
		return "ContainerInfo [id=" + id + ", created=" + created + ", path="
				+ path + ", args=" + Arrays.toString(args) + ", config="
				+ config + ", state=" + state + ", image=" + image
				+ ", networkSettings=" + networkSettings + ", resolvConfPath="
				+ resolvConfPath + ", hostnamePath=" + hostnamePath
				+ ", hostsPath=" + hostsPath + ", name=" + name + ", driver="
				+ driver + ", execDriver=" + execDriver + ", volumes="
				+ volumes + ", volumesRW=" + volumesRW + ", hostConfig="
				+ hostConfig + ", mountLabel=" + mountLabel + ", processLabel="
				+ processLabel + "]";
	}


	
}
