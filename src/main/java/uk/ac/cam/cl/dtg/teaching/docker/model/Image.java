package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

  @JsonProperty("Created")
  private Long created;

  @JsonProperty("Id")
  private String id;

  @JsonProperty("ParentId")
  private String parentId;

  @JsonProperty("RepoTags")
  private String[] repoTags;

  @JsonProperty("Size")
  private Long size;

  @JsonProperty("VirtualSize")
  private Long virtualSize;

  @JsonProperty("Labels")
  private Map<String, String> lables;

  @JsonProperty("RepoDigests")
  private String[] repoDigests;

  public String[] getRepoDigests() {
    return repoDigests;
  }

  public void setRepoDigests(String[] repoDigests) {
    this.repoDigests = repoDigests;
  }

  public Map<String, String> getLables() {
    return lables;
  }

  public void setLables(Map<String, String> lables) {
    this.lables = lables;
  }

  public Long getCreated() {
    return created;
  }

  public void setCreated(Long created) {
    this.created = created;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String[] getRepoTags() {
    return repoTags;
  }

  public void setRepoTags(String[] repoTags) {
    this.repoTags = repoTags;
  }

  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public Long getVirtualSize() {
    return virtualSize;
  }

  public void setVirtualSize(Long virtualSize) {
    this.virtualSize = virtualSize;
  }
}
