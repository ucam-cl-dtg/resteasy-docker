package uk.ac.cam.cl.dtg.teaching.docker.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LogConfig {

	@JsonProperty("Config")
	private Map<String,String> config;
	
	
	/**
	 * Available types: json-file, syslog, journald, gelf, awslogs, none. json-file
	 */
	@JsonProperty("Type")
	private String type;
	
	public LogConfig() {}

	
	public Map<String, String> getConfig() {
		return config;
	}

	public void setConfig(Map<String, String> config) {
		this.config = config;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
