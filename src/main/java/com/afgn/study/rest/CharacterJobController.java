package com.afgn.study.rest;

import com.afgn.study.rest.dto.CharacterDto;
import com.afgn.study.rest.dto.JobDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

public interface CharacterJobController {

    @GetMapping("/characters/{characterId}/jobs")
    ResponseEntity<List<JobDto>> getAllJobsFromCharacter(Pageable pageable, @PathVariable UUID characterId);

    @PostMapping("/characters/{characterId}/jobs/{jobId}")
    ResponseEntity<CharacterDto> addJobToCharacter(@PathVariable UUID characterId, @PathVariable UUID jobId) throws URISyntaxException;
}
