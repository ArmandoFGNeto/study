package com.afgn.study.rest.impl;

import com.afgn.study.rest.CharacterJobController;
import com.afgn.study.rest.dto.CharacterDto;
import com.afgn.study.rest.dto.JobDto;
import com.afgn.study.rest.util.PaginationUtil;
import com.afgn.study.service.CharacterJobService;
import com.afgn.study.service.mapper.JobMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CharacterJobControllerImpl implements CharacterJobController {

    private final CharacterJobService myCharacterJobService;
    private final JobMapper myJobMapper;

    public CharacterJobControllerImpl(CharacterJobService characterJobService, JobMapper jobMapper) {
        myCharacterJobService = characterJobService;
        myJobMapper = jobMapper;
    }

    @Override
    public ResponseEntity<List<JobDto>> getAllJobsFromCharacter(Pageable pageable, UUID characterId) {
        Page<JobDto> page = myCharacterJobService.findAllFromCharacter(pageable, characterId).map(myJobMapper::toDto);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(
                page, "api/v1/characters/" + characterId + "/jobs");
        return new ResponseEntity<List<JobDto>>(page.getContent(), headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JobDto> addJobToCharacter(@NotNull @Valid CharacterDto character) throws URISyntaxException {
        return null;
    }
}
