package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionJpaRepository extends JpaRepository<Session, Long> {

    List<Session> findByNameContains(String sessionName);
    List<Session> findByLengthNot(Integer length);
    List<Session> findByNameStartingWith(String sessionName);
    List<Session> findByNameEndingWith(String sessionName);
}
