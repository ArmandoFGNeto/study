package com.afgn.study.service.mapper.impl;

import com.afgn.study.domain.Job;
import com.afgn.study.rest.dto.JobDto;
import com.afgn.study.service.mapper.JobMapper;
import org.springframework.stereotype.Component;

@Component
public class JobMapperImpl implements JobMapper {

    @Override
    public Job toEntity(JobDto jobDTO) {
        return Job.newBuilder()
                .withName(jobDTO.getName())
                .withLevel(jobDTO.getLevel())
                .build();
    }

    @Override
    public JobDto toDto(Job job) {
        return new JobDto(job);
    }
}
