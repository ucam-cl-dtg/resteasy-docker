package uk.ac.cam.cl.dtg.teaching.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ipd21 on 19/03/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ContainerPort {
    @JsonProperty("PrivatePort")
    private int privatePort;

    @JsonProperty("PublicPort")
    private int publicPort;

    @JsonProperty("Type")
    private String type;

    public ContainerPort(int privatePort, int publicPort, String type) {
        this.privatePort = privatePort;
        this.publicPort = publicPort;
        this.type = type;
    }

    public ContainerPort() {}

    public int getPrivatePort() {
        return privatePort;
    }

    public void setPrivatePort(int privatePort) {
        this.privatePort = privatePort;
    }

    public int getPublicPort() {
        return publicPort;
    }

    public void setPublicPort(int publicPort) {
        this.publicPort = publicPort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
