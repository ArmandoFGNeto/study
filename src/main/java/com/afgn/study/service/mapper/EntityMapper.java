package com.afgn.study.service.mapper;

public interface EntityMapper<T, K> {

    T toEntity(K k);

    K toDto(T t);
}
