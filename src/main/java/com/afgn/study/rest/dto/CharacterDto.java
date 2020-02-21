package com.afgn.study.rest.dto;

import com.afgn.study.domain.Character;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CharacterDto {

    @JsonProperty("id")
    private UUID myId;
    @JsonProperty("name")
    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name max allowed length is 255 characters")
    private String myName;

    public CharacterDto() {}

    public CharacterDto(Character character) {
        setId(character.getId());
        setName(character.getName());
    }

    public UUID getId() {
        return myId;
    }

    public void setId(UUID id) {
        myId = id;
    }

    public String getName() {
        return myName;
    }

    public void setName(String name) {
        myName = name;
    }
}
