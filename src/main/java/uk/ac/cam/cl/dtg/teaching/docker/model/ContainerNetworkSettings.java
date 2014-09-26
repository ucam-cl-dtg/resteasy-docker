package uk.ac.cam.cl.dtg.teaching.docker.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainerNetworkSettings {
	
	@JsonProperty("IPAddress")
	private String ipAddress;
	
	@JsonProperty("IPPrefixLen")
	private Integer ipPrefixLen;
	
	@JsonProperty("Gateway")
	private String gateway;
	
	@JsonProperty("Bridge")
	private String bridge;
	
	@JsonProperty("PortMapping")
	private String portMapping;
	
	@JsonProperty("Ports")
	private Map<String,?> ports;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getIpPrefixLen() {
		return ipPrefixLen;
	}

	public void setIpPrefixLen(Integer ipPrefixLen) {
		this.ipPrefixLen = ipPrefixLen;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getPortMapping() {
		return portMapping;
	}

	public void setPortMapping(String portMapping) {
		this.portMapping = portMapping;
	}

	public Map<String, ?> getPorts() {
		return ports;
	}

	public void setPorts(Map<String, ?> ports) {
		this.ports = ports;
	}
	
	
	
}
