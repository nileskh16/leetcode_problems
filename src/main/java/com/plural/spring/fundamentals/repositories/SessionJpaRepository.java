package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionJpaRepository extends JpaRepository<Session, Long> {
}
