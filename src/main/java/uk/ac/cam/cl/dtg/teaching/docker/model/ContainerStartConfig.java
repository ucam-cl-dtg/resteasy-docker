package uk.ac.cam.cl.dtg.teaching.docker.model;

import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainerStartConfig {

	@JsonProperty("Binds")
	private String[] binds;

	@JsonProperty("LxcConf")
	private Map<String,String> lxcConf;
	
	@JsonProperty("PortBindings")
	private Map<String,?> portBindings;

	@JsonProperty("PublishAllPorts")
	private Boolean publishAllPorts;

	@JsonProperty("Privileged")
	private Boolean privileged;

	@JsonProperty("Dns")
	private String[] dns;
	
	@JsonProperty("VolumesFrom")
	private String[] volumesFrom;

	public String[] getBinds() {
		return binds;
	}

	public void setBinds(String[] binds) {
		this.binds = binds;
	}

	public Map<String, String> getLxcConf() {
		return lxcConf;
	}

	public void setLxcConf(Map<String, String> lxcConf) {
		this.lxcConf = lxcConf;
	}

	public Map<String, ?> getPortBindings() {
		return portBindings;
	}

	public void setPortBindings(Map<String, ?> portBindings) {
		this.portBindings = portBindings;
	}

	public Boolean getPublishAllPorts() {
		return publishAllPorts;
	}

	public void setPublishAllPorts(Boolean publishAllPorts) {
		this.publishAllPorts = publishAllPorts;
	}

	public Boolean getPrivileged() {
		return privileged;
	}

	public void setPrivileged(Boolean privileged) {
		this.privileged = privileged;
	}

	public String[] getDns() {
		return dns;
	}

	public void setDns(String[] dns) {
		this.dns = dns;
	}

	public String[] getVolumesFrom() {
		return volumesFrom;
	}

	public void setVolumesFrom(String[] volumesFrom) {
		this.volumesFrom = volumesFrom;
	}

	@Override
	public String toString() {
		return "ContainerStartConfig ["
				+ (binds != null ? "binds=" + Arrays.toString(binds) + ", "
						: "")
				+ (lxcConf != null ? "lxcConf=" + lxcConf + ", " : "")
				+ (portBindings != null ? "portBindings=" + portBindings + ", "
						: "")
				+ (publishAllPorts != null ? "publishAllPorts="
						+ publishAllPorts + ", " : "")
				+ (privileged != null ? "privileged=" + privileged + ", " : "")
				+ (dns != null ? "dns=" + Arrays.toString(dns) + ", " : "")
				+ (volumesFrom != null ? "volumesFrom="
						+ Arrays.toString(volumesFrom) : "") + "]";
	}


}