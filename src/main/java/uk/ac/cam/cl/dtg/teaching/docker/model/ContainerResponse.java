package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerResponse {

  @JsonProperty("Id")
  private String id;

  @JsonProperty("Warnings")
  private String[] warnings;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String[] getWarnings() {
    return warnings;
  }

  public void setWarnings(String[] warnings) {
    this.warnings = warnings;
  }

  @Override
  public String toString() {
    return "ContainerResponse [id=" + id + ", warnings=" + Arrays.toString(warnings) + "]";
  }
}
