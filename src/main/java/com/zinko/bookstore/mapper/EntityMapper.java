package com.zinko.bookstore.mapper;

public interface EntityMapper<T, E> {
    T mapToEntity(E dto);
    E mapFromEntity(T t);
}
