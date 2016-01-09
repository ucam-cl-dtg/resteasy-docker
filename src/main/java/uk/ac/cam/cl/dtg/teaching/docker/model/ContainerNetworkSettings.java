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

	@JsonProperty("MacAddress")
	private String macAddress;

	@JsonProperty("LinkLocalIPv6Address")
	private String linkLocalIPv6Address;

	@JsonProperty("LinkLocalIPv6PrefixLen")
	private String linkLocalIPv6PrefixLen;
	
	@JsonProperty("GlobalIPv6Address")
	private String globalIPv6Address;
	
	@JsonProperty("GlobalIPv6PrefixLen")
	private String globalIPv6PrexixLen;

	@JsonProperty("IPv6Gateway")
	private String ipv6Gateway;
	
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

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getLinkLocalIPv6Address() {
		return linkLocalIPv6Address;
	}

	public void setLinkLocalIPv6Address(String linkLocalIPv6Address) {
		this.linkLocalIPv6Address = linkLocalIPv6Address;
	}

	public String getLinkLocalIPv6PrefixLen() {
		return linkLocalIPv6PrefixLen;
	}

	public void setLinkLocalIPv6PrefixLen(String linkLocalIPv6PrefixLen) {
		this.linkLocalIPv6PrefixLen = linkLocalIPv6PrefixLen;
	}

	public String getGlobalIPv6Address() {
		return globalIPv6Address;
	}

	public void setGlobalIPv6Address(String globalIPv6Address) {
		this.globalIPv6Address = globalIPv6Address;
	}

	public String getGlobalIPv6PrexixLen() {
		return globalIPv6PrexixLen;
	}

	public void setGlobalIPv6PrexixLen(String globalIPv6PrexixLen) {
		this.globalIPv6PrexixLen = globalIPv6PrexixLen;
	}

	public String getIpv6Gateway() {
		return ipv6Gateway;
	}

	public void setIpv6Gateway(String ipv6Gateway) {
		this.ipv6Gateway = ipv6Gateway;
	}
	
	
	
}
