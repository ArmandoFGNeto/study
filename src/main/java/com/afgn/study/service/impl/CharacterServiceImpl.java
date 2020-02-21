package com.afgn.study.service.impl;

import com.afgn.study.dao.CharacterRepository;
import com.afgn.study.domain.Character;
import com.afgn.study.service.CharacterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository myCharacterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        myCharacterRepository = characterRepository;
    }

    @Override
    public Character create(String name) {
        return myCharacterRepository.save(Character.newBuilder().withName(name).build());
    }

    @Override
    public Page<Character> findAll(Pageable pageable) {
        return myCharacterRepository.findAll(pageable);
    }

    @Override
    public Optional<Character> findById(UUID id) {
        return myCharacterRepository.findById(id);
    }
}
