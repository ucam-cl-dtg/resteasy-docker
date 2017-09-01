package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemInfo {

  @JsonProperty("Architecture")
  private String architecture;

  @JsonProperty("BridgeNfIp6tables")
  private Boolean bridgeNfIp6tables;

  @JsonProperty("BridgeNfIptables")
  private Boolean bridgeNfIptables;

  @JsonProperty("CPUSet")
  private Boolean cpuSet;

  @JsonProperty("CPUShares")
  private Boolean cpuShares;

  @JsonProperty("CgroupDriver")
  private String cgroupDriver;

  @JsonProperty("ClusterAdvertise")
  private String clusterAdvertise;

  @JsonProperty("ClusterStore")
  private String clusterStore;

  @JsonProperty("Containers")
  private Integer containers;

  @JsonProperty("ContainersPaused")
  private Integer containersPaused;

  @JsonProperty("ContainersRunning")
  private Integer containersRunning;

  @JsonProperty("ContainersStopped")
  private Integer containersStopped;

  @JsonProperty("CpuCfsPeriod")
  private Boolean cpuCfsPeriod;

  @JsonProperty("CpuCfsQuota")
  private Boolean cpuCfsQuota;

  @JsonProperty("Debug")
  private Boolean debug;

  @JsonProperty("DockerRootDir")
  private String dockerRootDir;

  @JsonProperty("Driver")
  private String driver;

  @JsonProperty("DriverStatus")
  private List<?> driverStatus;

  @JsonProperty("ExecutionDriver")
  private String executionDriver;

  @JsonProperty("ExperimentalBuild")
  private Boolean experimentalBuild;

  @JsonProperty("HttpProxy")
  private String httpProxy;

  @JsonProperty("HttpsProxy")
  private String httpsProxy;

  @JsonProperty("ID")
  private String id;

  @JsonProperty("IPv4Forwarding")
  private Boolean ipv4Forwarding;

  @JsonProperty("Images")
  private Integer images;

  @JsonProperty("IndexServerAddress")
  private String indexServerAddress;

  @JsonProperty("KernelMemory")
  private Boolean kernelMemory;

  @JsonProperty("KernelVersion")
  private String kernelVersion;

  @JsonProperty("Labels")
  private String labels;

  @JsonProperty("LoggingDriver")
  private String loggingDriver;

  @JsonProperty("MemTotal")
  private Long memTotal;

  @JsonProperty("MemoryLimit")
  private Boolean memoryLimit;

  @JsonProperty("NCPU")
  private Integer nCPU;

  @JsonProperty("NEventsListener")
  private Integer nEventsListener;

  @JsonProperty("NFd")
  private Integer nFd;

  @JsonProperty("NGoroutines")
  private Integer nGoroutines;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("NoProxy")
  private String noProxy;

  @JsonProperty("OSType")
  private String osType;

  @JsonProperty("OomKillDisable")
  private Boolean oomKillDisable;

  @JsonProperty("OperatingSystem")
  private String operatingSystem;

  @JsonProperty("Plugins")
  private Map<String, ?> plugins;

  @JsonProperty("RegistryConfig")
  private Map<String, ?> registryConfig;

  @JsonProperty("ServerVersion")
  private String serverVersion;

  @JsonProperty("SwapLimit")
  private Boolean swapLimit;

  @JsonProperty("SystemStatus")
  private String systemStatus;

  @JsonProperty("SystemTime")
  private String systemTime;

  public String getArchitecture() {
    return architecture;
  }

  public void setArchitecture(String architecture) {
    this.architecture = architecture;
  }

  public Boolean getBridgeNfIp6tables() {
    return bridgeNfIp6tables;
  }

  public void setBridgeNfIp6tables(Boolean bridgeNfIp6tables) {
    this.bridgeNfIp6tables = bridgeNfIp6tables;
  }

  public Boolean getBridgeNfIptables() {
    return bridgeNfIptables;
  }

  public void setBridgeNfIptables(Boolean bridgeNfIptables) {
    this.bridgeNfIptables = bridgeNfIptables;
  }

  public Boolean getCpuSet() {
    return cpuSet;
  }

  public void setCpuSet(Boolean cpuSet) {
    this.cpuSet = cpuSet;
  }

  public Boolean getCpuShares() {
    return cpuShares;
  }

  public void setCpuShares(Boolean cpuShares) {
    this.cpuShares = cpuShares;
  }

  public String getCgroupDriver() {
    return cgroupDriver;
  }

  public void setCgroupDriver(String cgroupDriver) {
    this.cgroupDriver = cgroupDriver;
  }

  public String getClusterAdvertise() {
    return clusterAdvertise;
  }

  public void setClusterAdvertise(String clusterAdvertise) {
    this.clusterAdvertise = clusterAdvertise;
  }

  public String getClusterStore() {
    return clusterStore;
  }

  public void setClusterStore(String clusterStore) {
    this.clusterStore = clusterStore;
  }

  public Integer getContainers() {
    return containers;
  }

  public void setContainers(Integer containers) {
    this.containers = containers;
  }

  public Integer getContainersPaused() {
    return containersPaused;
  }

  public void setContainersPaused(Integer containersPaused) {
    this.containersPaused = containersPaused;
  }

  public Integer getContainersRunning() {
    return containersRunning;
  }

  public void setContainersRunning(Integer containersRunning) {
    this.containersRunning = containersRunning;
  }

  public Integer getContainersStopped() {
    return containersStopped;
  }

  public void setContainersStopped(Integer containersStopped) {
    this.containersStopped = containersStopped;
  }

  public Boolean getCpuCfsPeriod() {
    return cpuCfsPeriod;
  }

  public void setCpuCfsPeriod(Boolean cpuCfsPeriod) {
    this.cpuCfsPeriod = cpuCfsPeriod;
  }

  public Boolean getCpuCfsQuota() {
    return cpuCfsQuota;
  }

  public void setCpuCfsQuota(Boolean cpuCfsQuota) {
    this.cpuCfsQuota = cpuCfsQuota;
  }

  public Boolean getDebug() {
    return debug;
  }

  public void setDebug(Boolean debug) {
    this.debug = debug;
  }

  public String getDockerRootDir() {
    return dockerRootDir;
  }

  public void setDockerRootDir(String dockerRootDir) {
    this.dockerRootDir = dockerRootDir;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public List<?> getDriverStatus() {
    return driverStatus;
  }

  public void setDriverStatus(List<?> driverStatus) {
    this.driverStatus = driverStatus;
  }

  public String getExecutionDriver() {
    return executionDriver;
  }

  public void setExecutionDriver(String executionDriver) {
    this.executionDriver = executionDriver;
  }

  public Boolean getExperimentalBuild() {
    return experimentalBuild;
  }

  public void setExperimentalBuild(Boolean experimentalBuild) {
    this.experimentalBuild = experimentalBuild;
  }

  public String getHttpProxy() {
    return httpProxy;
  }

  public void setHttpProxy(String httpProxy) {
    this.httpProxy = httpProxy;
  }

  public String getHttpsProxy() {
    return httpsProxy;
  }

  public void setHttpsProxy(String httpsProxy) {
    this.httpsProxy = httpsProxy;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Boolean getIpv4Forwarding() {
    return ipv4Forwarding;
  }

  public void setIpv4Forwarding(Boolean ipv4Forwarding) {
    this.ipv4Forwarding = ipv4Forwarding;
  }

  public Integer getImages() {
    return images;
  }

  public void setImages(Integer images) {
    this.images = images;
  }

  public String getIndexServerAddress() {
    return indexServerAddress;
  }

  public void setIndexServerAddress(String indexServerAddress) {
    this.indexServerAddress = indexServerAddress;
  }

  public Boolean getKernelMemory() {
    return kernelMemory;
  }

  public void setKernelMemory(Boolean kernelMemory) {
    this.kernelMemory = kernelMemory;
  }

  public String getKernelVersion() {
    return kernelVersion;
  }

  public void setKernelVersion(String kernelVersion) {
    this.kernelVersion = kernelVersion;
  }

  public String getLabels() {
    return labels;
  }

  public void setLabels(String labels) {
    this.labels = labels;
  }

  public String getLoggingDriver() {
    return loggingDriver;
  }

  public void setLoggingDriver(String loggingDriver) {
    this.loggingDriver = loggingDriver;
  }

  public Long getMemTotal() {
    return memTotal;
  }

  public void setMemTotal(Long memTotal) {
    this.memTotal = memTotal;
  }

  public Boolean getMemoryLimit() {
    return memoryLimit;
  }

  public void setMemoryLimit(Boolean memoryLimit) {
    this.memoryLimit = memoryLimit;
  }

  public Integer getnCPU() {
    return nCPU;
  }

  public void setnCPU(Integer nCPU) {
    this.nCPU = nCPU;
  }

  public Integer getnEventsListener() {
    return nEventsListener;
  }

  public void setnEventsListener(Integer nEventsListener) {
    this.nEventsListener = nEventsListener;
  }

  public Integer getnFd() {
    return nFd;
  }

  public void setnFd(Integer nFd) {
    this.nFd = nFd;
  }

  public Integer getnGoroutines() {
    return nGoroutines;
  }

  public void setnGoroutines(Integer nGoroutines) {
    this.nGoroutines = nGoroutines;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNoProxy() {
    return noProxy;
  }

  public void setNoProxy(String noProxy) {
    this.noProxy = noProxy;
  }

  public String getOsType() {
    return osType;
  }

  public void setOsType(String osType) {
    this.osType = osType;
  }

  public Boolean getOomKillDisable() {
    return oomKillDisable;
  }

  public void setOomKillDisable(Boolean oomKillDisable) {
    this.oomKillDisable = oomKillDisable;
  }

  public String getOperatingSystem() {
    return operatingSystem;
  }

  public void setOperatingSystem(String operatingSystem) {
    this.operatingSystem = operatingSystem;
  }

  public Map<String, ?> getPlugins() {
    return plugins;
  }

  public void setPlugins(Map<String, ?> plugins) {
    this.plugins = plugins;
  }

  public Map<String, ?> getRegistryConfig() {
    return registryConfig;
  }

  public void setRegistryConfig(Map<String, ?> registryConfig) {
    this.registryConfig = registryConfig;
  }

  public String getServerVersion() {
    return serverVersion;
  }

  public void setServerVersion(String serverVersion) {
    this.serverVersion = serverVersion;
  }

  public Boolean getSwapLimit() {
    return swapLimit;
  }

  public void setSwapLimit(Boolean swapLimit) {
    this.swapLimit = swapLimit;
  }

  public String getSystemStatus() {
    return systemStatus;
  }

  public void setSystemStatus(String systemStatus) {
    this.systemStatus = systemStatus;
  }

  public String getSystemTime() {
    return systemTime;
  }

  public void setSystemTime(String systemTime) {
    this.systemTime = systemTime;
  }
}
