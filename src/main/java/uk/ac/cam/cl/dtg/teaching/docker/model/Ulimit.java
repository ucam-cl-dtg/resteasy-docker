package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ulimit {
	@JsonProperty("Name")
	private String name;

	@JsonProperty("Soft")
	private Integer soft;

	@JsonProperty("Hard")
	private Integer hard;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSoft() {
		return soft;
	}

	public void setSoft(Integer soft) {
		this.soft = soft;
	}

	public Integer getHard() {
		return hard;
	}

	public void setHard(Integer hard) {
		this.hard = hard;
	}
	
	
}
