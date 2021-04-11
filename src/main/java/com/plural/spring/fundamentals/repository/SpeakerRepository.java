package com.plural.spring.fundamentals.repository;

import java.util.List;

public interface SpeakerRepository<T> {
    List<T> findAll();
}
