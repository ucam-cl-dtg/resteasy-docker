package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerNetworkSettings {

  @JsonProperty("Bridge")
  private String bridge;

  @JsonProperty("SandboxID")
  private String sandboxID;

  @JsonProperty("HairpinMode")
  private Boolean hairpinMode;

  @JsonProperty("LinkLocalIPv6Address")
  private String linkLocalIPv6Address;

  @JsonProperty("LinkLocalIPv6PrefixLen")
  private String linkLocalIPv6PrefixLen;

  @JsonProperty("Ports")
  private Map<String, ?> ports;

  @JsonProperty("SandboxKey")
  private String sandboxKey;

  @JsonProperty("SecondaryIPAddresses")
  private List<String> secondaryIPAddresses;

  @JsonProperty("SecondaryIPv6Addresses")
  private List<String> secondaryIPv6Addresses;

  @JsonProperty("EndpointID")
  private String endpointID;

  @JsonProperty("Gateway")
  private String gateway;

  @JsonProperty("GlobalIPv6Address")
  private String globalIPv6Address;

  @JsonProperty("GlobalIPv6PrefixLen")
  private String globalIPv6PrexixLen;

  @JsonProperty("IPAddress")
  private String ipAddress;

  @JsonProperty("IPPrefixLen")
  private Integer ipPrefixLen;

  @JsonProperty("IPv6Gateway")
  private String ipv6Gateway;

  @JsonProperty("MacAddress")
  private String macAddress;

  @JsonProperty("Networks")
  private Map<String, ?> networks;

  public String getSandboxID() {
    return sandboxID;
  }

  public void setSandboxID(String sandboxID) {
    this.sandboxID = sandboxID;
  }

  public Boolean getHairpinMode() {
    return hairpinMode;
  }

  public void setHairpinMode(Boolean hairpinMode) {
    this.hairpinMode = hairpinMode;
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

  public Map<String, ?> getPorts() {
    return ports;
  }

  public void setPorts(Map<String, ?> ports) {
    this.ports = ports;
  }

  public String getSandboxKey() {
    return sandboxKey;
  }

  public void setSandboxKey(String sandboxKey) {
    this.sandboxKey = sandboxKey;
  }

  public List<String> getSecondaryIPAddresses() {
    return secondaryIPAddresses;
  }

  public void setSecondaryIPAddresses(List<String> secondaryIPAddresses) {
    this.secondaryIPAddresses = secondaryIPAddresses;
  }

  public List<String> getSecondaryIPv6Addresses() {
    return secondaryIPv6Addresses;
  }

  public void setSecondaryIPv6Addresses(List<String> secondaryIPv6Addresses) {
    this.secondaryIPv6Addresses = secondaryIPv6Addresses;
  }

  public String getEndpointID() {
    return endpointID;
  }

  public void setEndpointID(String endpointID) {
    this.endpointID = endpointID;
  }

  public String getGateway() {
    return gateway;
  }

  public void setGateway(String gateway) {
    this.gateway = gateway;
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

  public String getIpv6Gateway() {
    return ipv6Gateway;
  }

  public void setIpv6Gateway(String ipv6Gateway) {
    this.ipv6Gateway = ipv6Gateway;
  }

  public String getMacAddress() {
    return macAddress;
  }

  public void setMacAddress(String macAddress) {
    this.macAddress = macAddress;
  }

  public Map<String, ?> getNetworks() {
    return networks;
  }

  public void setNetworks(Map<String, ?> networks) {
    this.networks = networks;
  }

  public String getBridge() {
    return bridge;
  }

  public void setBridge(String bridge) {
    this.bridge = bridge;
  }
}
