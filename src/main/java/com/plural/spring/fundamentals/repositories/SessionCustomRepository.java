package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Session;

import java.util.List;

public interface SessionCustomRepository {
    List<Session> getCustomSessionList(Integer length);
}
