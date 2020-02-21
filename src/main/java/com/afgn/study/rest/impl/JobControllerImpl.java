package com.afgn.study.rest.impl;

import com.afgn.study.rest.JobController;
import com.afgn.study.rest.dto.JobDto;
import com.afgn.study.rest.util.HeaderUtil;
import com.afgn.study.rest.util.PaginationUtil;
import com.afgn.study.service.JobService;
import com.afgn.study.service.mapper.JobMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@RestController
@RequestMapping("/api/v1")
public class JobControllerImpl implements JobController {

    private final JobService myJobService;
    private final JobMapper myJobMapper;

    public JobControllerImpl(JobService jobService, JobMapper jobMapper) {
        myJobService = jobService;
        myJobMapper = jobMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<JobDto>> getAllJobs(Pageable pageable) {
        Page<JobDto> page = myJobService.findAll(pageable).map(myJobMapper::toDto);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "api/v1/jobs");
        return new ResponseEntity<List<JobDto>>(page.getContent(), headers, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<JobDto> createJob(@NotNull @Valid JobDto jobDTO) throws URISyntaxException {
        jobDTO = myJobMapper.toDto(myJobService.create(jobDTO.getName(), jobDTO.getLevel()));
        return ResponseEntity.created(new URI("/api/v1/jobs/" + jobDTO.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, jobDTO.getId().toString()))
                .body(jobDTO);
    }
}
