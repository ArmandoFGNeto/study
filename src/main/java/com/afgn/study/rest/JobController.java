package com.afgn.study.rest;

import com.afgn.study.rest.dto.JobDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;

public interface JobController {

    @GetMapping("/jobs")
    ResponseEntity<List<JobDto>> getAllJobs(Pageable pageable);

    @PostMapping("/jobs")
    ResponseEntity<JobDto> createJob(@RequestBody @NotNull @Valid JobDto job) throws URISyntaxException;
}
