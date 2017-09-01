package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerState {

  @JsonProperty("Error")
  private String error;

  @JsonProperty("ExitCode")
  private Integer exitCode;

  @JsonProperty("FinishedAt")
  private String finishedAt;

  @JsonProperty("OOMKilled")
  private String oomKilled;

  /**
   * Set to true if this container is in the paused state. You can only pause/unpause a running
   * container, so if this value is true then running should be true also
   */
  @JsonProperty("Paused")
  private Boolean paused;

  @JsonProperty("Pid")
  private Integer pid;

  @JsonProperty("Restarting")
  private boolean restarting;

  /** Set to true if this container is running and false if it is stopped */
  @JsonProperty("Running")
  private Boolean running;

  @JsonProperty("StartedAt")
  private String startedAt;

  @JsonProperty("Status")
  private String status;

  @JsonProperty("Dead")
  private Boolean dead;

  public Boolean getDead() {
    return dead;
  }

  public void setDead(Boolean dead) {
    this.dead = dead;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Integer getExitCode() {
    return exitCode;
  }

  public void setExitCode(Integer exitCode) {
    this.exitCode = exitCode;
  }

  public String getFinishedAt() {
    return finishedAt;
  }

  public void setFinishedAt(String finishedAt) {
    this.finishedAt = finishedAt;
  }

  public String getOomKilled() {
    return oomKilled;
  }

  public void setOomKilled(String oomKilled) {
    this.oomKilled = oomKilled;
  }

  public Boolean getPaused() {
    return paused;
  }

  public void setPaused(Boolean paused) {
    this.paused = paused;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public boolean isRestarting() {
    return restarting;
  }

  public void setRestarting(boolean restarting) {
    this.restarting = restarting;
  }

  public Boolean getRunning() {
    return running;
  }

  public void setRunning(Boolean running) {
    this.running = running;
  }

  public String getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(String startedAt) {
    this.startedAt = startedAt;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
