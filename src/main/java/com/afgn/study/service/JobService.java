package com.afgn.study.service;

import com.afgn.study.domain.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {

    Job create(String name, int level);

    Page<Job> findAll(Pageable pageable);
}
