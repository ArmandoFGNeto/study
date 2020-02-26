package com.afgn.study.rest.impl;

import com.afgn.study.domain.Character;
import com.afgn.study.domain.CharacterJob;
import com.afgn.study.domain.Job;
import com.afgn.study.exception.EntityNotFoundException;
import com.afgn.study.rest.CharacterJobController;
import com.afgn.study.rest.dto.CharacterDto;
import com.afgn.study.rest.dto.JobDto;
import com.afgn.study.rest.util.HeaderUtil;
import com.afgn.study.rest.util.PaginationUtil;
import com.afgn.study.service.CharacterJobService;
import com.afgn.study.service.CharacterService;
import com.afgn.study.service.JobService;
import com.afgn.study.service.mapper.CharacterMapper;
import com.afgn.study.service.mapper.JobMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@RestController
@RequestMapping("/api/v1")
public class CharacterJobControllerImpl implements CharacterJobController {

    private final CharacterJobService myCharacterJobService;
    private final CharacterService myCharacterService;
    private final JobService myJobService;
    private final CharacterMapper myCharacterMapper;
    private final JobMapper myJobMapper;

    public CharacterJobControllerImpl(CharacterJobService characterJobService, CharacterService characterService,
                                      JobService jobService, CharacterMapper characterMapper, JobMapper jobMapper) {
        myCharacterJobService = characterJobService;
        myCharacterService = characterService;
        myJobService = jobService;
        myCharacterMapper = characterMapper;
        myJobMapper = jobMapper;
    }

    @Override
    public ResponseEntity<List<JobDto>> getAllJobsFromCharacter(Pageable pageable, UUID characterId) {
        Page<JobDto> page = myCharacterJobService.findAllFromCharacter(pageable, characterId).map(myJobMapper::toDto);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(
                page, "api/v1/characters/" + characterId + "/jobs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CharacterDto> addJobToCharacter(@PathVariable UUID characterId, @PathVariable UUID jobId) throws URISyntaxException {
        Optional<Character> possibleCharacter = myCharacterService.findById(characterId);
        if (possibleCharacter.isEmpty()) {
            throw new EntityNotFoundException("Character", "Id", characterId.toString());
        }

        Optional<Job> possibleJob = myJobService.findById(jobId);
        if (possibleJob.isEmpty()) {
            throw new EntityNotFoundException("Job", "Id", jobId.toString());
        }

        CharacterJob characterJob = myCharacterJobService.addJobToCharacter(characterId, jobId);
        CharacterDto characterDto = myCharacterMapper.toDto(possibleCharacter.get());
        return ResponseEntity.created(new URI("/api/v1/characters/" + characterDto.getId() + "/jobs"))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, characterDto.getId().toString()))
                .body(characterDto);
    }
}
