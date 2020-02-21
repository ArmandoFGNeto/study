package com.afgn.study.service;

import com.afgn.study.domain.CharacterJob;
import com.afgn.study.domain.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CharacterJobService {

    CharacterJob addJobToCharacter(UUID characterId, UUID jobId);

    Page<Job> findAllFromCharacter(Pageable pageable, UUID characterId);
}
