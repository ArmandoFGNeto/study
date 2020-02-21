package com.afgn.study.service.impl;

import com.afgn.study.dao.CharacterJobRepository;
import com.afgn.study.domain.CharacterJob;
import com.afgn.study.domain.Job;
import com.afgn.study.service.CharacterJobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CharacterJobServiceImpl implements CharacterJobService {

    private final CharacterJobRepository myCharacterJobRepository;

    public CharacterJobServiceImpl(CharacterJobRepository characterJobRepository) {
        myCharacterJobRepository = characterJobRepository;
    }

    @Override
    public CharacterJob addJobToCharacter(UUID characterId, UUID jobId) {
        return null;
    }

    @Override
    public Page<Job> findAllFromCharacter(Pageable pageable, UUID characterId) {
        return myCharacterJobRepository.findAllFromCharacter(pageable, characterId);
    }
}
