package com.afgn.study.service.mapper.impl;

import com.afgn.study.domain.Character;
import com.afgn.study.rest.dto.CharacterDto;
import com.afgn.study.service.mapper.CharacterMapper;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapperImpl implements CharacterMapper {

    @Override
    public Character toEntity(CharacterDto characterDto) {
        return Character.newBuilder()
                .withName(characterDto.getName())
                .build();
    }

    @Override
    public CharacterDto toDto(Character character) {
        return new CharacterDto(character);
    }
}
