package com.afgn.study.service.impl;

import com.afgn.study.dao.JobRepository;
import com.afgn.study.domain.Job;
import com.afgn.study.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository myJobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        myJobRepository = jobRepository;
    }

    @Override
    public Job create(String name, int level) {
        return myJobRepository.save(Job.newBuilder().withName(name).withLevel(level).build());
    }

    @Override
    public Page<Job> findAll(Pageable pageable) {
        return myJobRepository.findAll(pageable);
    }

    @Override
    public Optional<Job> findById(UUID jobId) {
        return myJobRepository.findById(jobId);
    }
}
