package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestartPolicy {

	@JsonProperty("MaximumRetryCount")
	private Integer maximumRetryCount;
	
	@JsonProperty("Name")
	private String name;

	public RestartPolicy() {}
	
	public Integer getMaximumRetryCount() {
		return maximumRetryCount;
	}

	public void setMaximumRetryCount(Integer maximumRetryCount) {
		this.maximumRetryCount = maximumRetryCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
