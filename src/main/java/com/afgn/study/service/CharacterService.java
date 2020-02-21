package com.afgn.study.service;

import com.afgn.study.domain.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CharacterService {

    Character create(String name);

    Page<Character> findAll(Pageable pageable);

    Optional<Character> findById(UUID characterId);
}
