package uk.ac.cam.cl.dtg.teaching.docker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RootFS {

	@JsonProperty("Type")
	private String type;
	
	@JsonProperty("Layers")
	private List<String> layers;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getLayers() {
		return layers;
	}

	public void setLayers(List<String> layers) {
		this.layers = layers;
	}
	
	
}
