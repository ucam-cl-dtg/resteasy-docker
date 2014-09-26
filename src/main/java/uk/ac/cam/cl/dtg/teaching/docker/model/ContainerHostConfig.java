package uk.ac.cam.cl.dtg.teaching.docker.model;

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

	
}