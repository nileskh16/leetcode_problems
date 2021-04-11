package com.plural.spring.fundamentals.services;

import java.util.List;

public interface SpeakerService<T> {
    List<T> findAllEntities();
}
