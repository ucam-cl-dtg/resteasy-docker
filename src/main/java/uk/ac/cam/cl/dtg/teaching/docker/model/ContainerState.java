package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainerState {

	/**
	 * Set to true if this container is running and false if it is stopped
	 */
	@JsonProperty("Running")
	private Boolean running;
	
	@JsonProperty("Pid")
	private Integer pid;
	
	@JsonProperty("ExitCode")
	private Integer exitCode;
	
	@JsonProperty("StartedAt")
	private String startedAt;
	
	@JsonProperty("FinishedAt")
	private String finishedAt;
	
	@JsonProperty("Ghost")
	private Boolean ghost;
	
	@JsonProperty("Restarting")
	private String restarting;

	@JsonProperty("OOMKilled")
	private String oomKilled;

	@JsonProperty("Dead")
	private String dead;

	
	/**
	 * Set to true if this container is in the paused state.  
	 * You can only pause/unpause a running container, so if this value is true then running should be true also
	 */
	@JsonProperty("Paused")
	private Boolean paused;

	
	@JsonProperty("Error")
	private String error;
	
	public Boolean isPaused() {
		return paused;
	}
	
	public void setPaused(Boolean paused) {
		this.paused = paused;
	}
	
	public Boolean isRunning() {
		return running;
	}

	public void setRunning(Boolean running) {
		this.running = running;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getExitCode() {
		return exitCode;
	}

	public void setExitCode(Integer exitCode) {
		this.exitCode = exitCode;
	}

	public String getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(String startedAt) {
		this.startedAt = startedAt;
	}

	public String getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(String finishedAt) {
		this.finishedAt = finishedAt;
	}

	public Boolean isGhost() {
		return ghost;
	}

	public void setGhost(Boolean ghost) {
		this.ghost = ghost;
	}

	public String getRestarting() {
		return restarting;
	}

	public void setRestarting(String restarting) {
		this.restarting = restarting;
	}

	public String getOomKilled() {
		return oomKilled;
	}

	public void setOomKilled(String oomKilled) {
		this.oomKilled = oomKilled;
	}

	public Boolean getRunning() {
		return running;
	}

	public Boolean getGhost() {
		return ghost;
	}

	public Boolean getPaused() {
		return paused;
	}

	public String getDead() {
		return dead;
	}

	public void setDead(String dead) {
		this.dead = dead;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
