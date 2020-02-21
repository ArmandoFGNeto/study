package com.afgn.study.rest.dto;

import com.afgn.study.domain.Job;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class JobDto {

    @JsonProperty("id")
    private UUID myId;
    @JsonProperty("name")
    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name max allowed length is 255 characters")
    private String myName;
    @JsonProperty("level")
    @NotNull(message = "Level is mandatory")
    private int myLevel;

    public JobDto() {}

    public JobDto(Job job) {
        setId(job.getId());
        setName(job.getName());
        setLevel(job.getLevel());
    }

    public UUID getId() {
        return myId;
    }

    public void setId(UUID myId) {
        this.myId = myId;
    }

    public String getName() {
        return myName;
    }

    public void setName(String myName) {
        this.myName = myName;
    }

    public int getLevel() {
        return myLevel;
    }

    public void setLevel(int myLevel) {
        this.myLevel = myLevel;
    }
}
