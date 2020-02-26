package com.afgn.study.rest.impl;

import com.afgn.study.domain.Character;
import com.afgn.study.exception.EntityNotFoundException;
import com.afgn.study.rest.CharacterController;
import com.afgn.study.rest.dto.CharacterDto;
import com.afgn.study.rest.util.HeaderUtil;
import com.afgn.study.rest.util.PaginationUtil;
import com.afgn.study.service.CharacterService;
import com.afgn.study.service.mapper.CharacterMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@RestController
@RequestMapping("/api/v1")
public class CharacterControllerImpl implements CharacterController {

    private final CharacterService myCharacterService;
    private final CharacterMapper myCharacterMapper;

    public CharacterControllerImpl(CharacterService characterService, CharacterMapper characterMapper) {
        myCharacterService = characterService;
        myCharacterMapper = characterMapper;
    }

    @Override
    public ResponseEntity<List<CharacterDto>> getAllCharacters(Pageable pageable) {
        Page<CharacterDto> page = myCharacterService.findAll(pageable).map(myCharacterMapper::toDto);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "api/v1/characters");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CharacterDto> getCharacterById(@PathVariable UUID characterId) throws EntityNotFoundException {
        Optional<Character> possibleCharacter = myCharacterService.findById(characterId);

        if (possibleCharacter.isPresent()) {
            return ResponseEntity.ok().body(myCharacterMapper.toDto(possibleCharacter.get()));
        }
        throw new EntityNotFoundException("Character", "id", characterId.toString());
    }

    @Override
    public ResponseEntity<CharacterDto> createCharacter(@NotNull @Valid CharacterDto characterDto) throws URISyntaxException {
        characterDto = myCharacterMapper.toDto(myCharacterService.create(characterDto.getName()));
        return ResponseEntity.created(new URI("/api/v1/characters/" + characterDto.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, characterDto.getId().toString()))
                .body(characterDto);
    }
}
