package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
