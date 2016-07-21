package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ContainerMount {

	@JsonProperty("Name")
	private String name;
	
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

	@JsonProperty("Driver")
	private String driver;
		
	@JsonProperty("Propagation")
	private String propagation;
	
	
	public String getPropagation() {
		return propagation;
	}

	public void setPropagation(String propagation) {
		this.propagation = propagation;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
