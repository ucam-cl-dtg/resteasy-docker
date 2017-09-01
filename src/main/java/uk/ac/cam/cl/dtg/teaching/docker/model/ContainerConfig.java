package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerConfig {

  /** A string value containing the hostname to use for the container. */
  @JsonProperty("Hostname")
  private String hostname = "";

  /** A string value containing the domain name to use for the container. */
  @JsonProperty("Domainname")
  private String domainname = "";

  /** A string value specifying the user inside the container. */
  @JsonProperty("User")
  private String user = "";

  /** Boolean value, attaches to stdin. */
  @JsonProperty("AttachStdin")
  private Boolean attachStdin;

  /** Boolean value, attaches to stdout. */
  @JsonProperty("AttachStdout")
  private Boolean attachStdout;

  /** Boolean value, attaches to stderr. */
  @JsonProperty("AttachStderr")
  private Boolean attachStderr;

  /** Boolean value, Attach standard streams to a tty, including stdin if it is not closed. */
  @JsonProperty("Tty")
  private Boolean tty;

  /** Boolean value, opens stdin. */
  @JsonProperty("OpenStdin")
  private Boolean openStdin;

  /** Boolean value, close stdin after the 1 attached client disconnects. */
  @JsonProperty("StdinOnce")
  private Boolean stdinOnce;

  /** A list of environment variables in the form of ["VAR=value"[,"VAR2=value2"]]. */
  @JsonProperty("Env")
  private List<String> env;

  /** Command to run specified as a string or an array of strings. */
  @JsonProperty("Cmd")
  private List<String> cmd;

  /** Set the entry point for the container as a string or an array of strings. */
  @JsonProperty("Entrypoint")
  private String[] entryPoint;

  /** A string specifying the image name to use for the container. */
  @JsonProperty("Image")
  private String image;

  /** Custom metadata which you can add to a container. Stored as key/value pairs */
  @JsonProperty("Labels")
  private Map<String, String> labels;

  /** An array of mount points in the container. */
  @JsonProperty("Mounts")
  private List<ContainerMount> mounts;

  /** A string specifying the working directory for commands to run in. */
  @JsonProperty("WorkingDir")
  private String workingDir = "";

  /** Boolean value, when true disables networking for the container. */
  @JsonProperty("NetworkDisabled")
  private Boolean networkDisabled;

  @JsonProperty("MacAddress")
  private String macAddress;

  /**
   * An object mapping ports to an empty object in the form of:
   * "ExposedPorts": { "&lt;port>/&lt;tcp|udp>: {}" }.
   */
  @JsonProperty("ExposedPorts")
  private Map<String, ?> exposedPorts;

  /** Signal to stop a container as a string or unsigned integer. SIGTERM by default. */
  @JsonProperty("StopSignal")
  private String stopSignal;

  @JsonProperty("HostConfig")
  private ContainerHostConfig hostConfig;

  @JsonProperty("Volumes")
  private Map<String, Map<String, String>> volumes;

  public Map<String, Map<String, String>> getVolumes() {
    return volumes;
  }

  public void setVolumes(Map<String, Map<String, String>> volumes) {
    this.volumes = volumes;
  }

  @JsonProperty("OnBuild")
  private String onBuild;

  public String getOnBuild() {
    return onBuild;
  }

  public void setOnBuild(String onBuild) {
    this.onBuild = onBuild;
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

  public List<String> getCmd() {
    return cmd;
  }

  public void setCmd(List<String> cmd) {
    this.cmd = cmd;
  }

  public String[] getEntryPoint() {
    return entryPoint;
  }

  public void setEntryPoint(String[] entryPoint) {
    this.entryPoint = entryPoint;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }

  public List<ContainerMount> getMounts() {
    return mounts;
  }

  public void setMounts(List<ContainerMount> mounts) {
    this.mounts = mounts;
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

  public String getMacAddress() {
    return macAddress;
  }

  public void setMacAddress(String macAddress) {
    this.macAddress = macAddress;
  }

  public Map<String, ?> getExposedPorts() {
    return exposedPorts;
  }

  public void setExposedPorts(Map<String, ?> exposedPorts) {
    this.exposedPorts = exposedPorts;
  }

  public String getStopSignal() {
    return stopSignal;
  }

  public void setStopSignal(String stopSignal) {
    this.stopSignal = stopSignal;
  }

  public ContainerHostConfig getHostConfig() {
    return hostConfig;
  }

  public void setHostConfig(ContainerHostConfig hostConfig) {
    this.hostConfig = hostConfig;
  }
}
