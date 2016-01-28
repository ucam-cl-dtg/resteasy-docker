package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainerMount {

	@JsonProperty("Source")
	private String source;
	
	@JsonProperty("Destination")
	private String destination;
	
	/**
	 * e.g. ro,Z
	 */
	@JsonProperty("Mode")
	private String mode;
	
	@JsonProperty("RW")
	private Boolean rw;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Boolean getRw() {
		return rw;
	}

	public void setRw(Boolean rw) {
		this.rw = rw;
	}
	
	
}
