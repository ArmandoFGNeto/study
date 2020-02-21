package com.afgn.study.rest;

import com.afgn.study.exception.EntityNotFoundException;
import com.afgn.study.rest.dto.CharacterDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

public interface CharacterController {

    @GetMapping("/characters")
    ResponseEntity<List<CharacterDto>> getAllCharacters(Pageable pageable);

    @GetMapping("/characters/{characterId}")
    ResponseEntity<CharacterDto> getCharacterById(@PathVariable UUID characterId) throws EntityNotFoundException;

    @PostMapping("/characters")
    ResponseEntity<CharacterDto> createCharacter(@RequestBody @NotNull @Valid CharacterDto characterDto) throws URISyntaxException;
}
