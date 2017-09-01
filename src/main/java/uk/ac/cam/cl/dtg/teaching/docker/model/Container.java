package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Container {

  @JsonProperty("Command")
  private String command;

  @JsonProperty("Created")
  private long created;

  @JsonProperty("Id")
  private String id;

  @JsonProperty("Image")
  private String image;

  @JsonProperty("Names")
  private String[] names;

  @JsonProperty("Ports")
  private int[] ports;

  @JsonProperty("Status")
  private String status;

  public Container() {}

  public Container(
      String command, long created, String id, String image, String[] names, int[] ports) {
    super();
    this.command = command;
    this.created = created;
    this.id = id;
    this.image = image;
    this.names = names;
    this.ports = ports;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public long getCreated() {
    return created;
  }

  public void setCreated(long created) {
    this.created = created;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String[] getNames() {
    return names;
  }

  public void setNames(String[] names) {
    this.names = names;
  }

  public int[] getPorts() {
    return ports;
  }

  public void setPorts(int[] ports) {
    this.ports = ports;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
