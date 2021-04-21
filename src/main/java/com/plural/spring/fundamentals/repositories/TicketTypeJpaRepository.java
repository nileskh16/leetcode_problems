package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketTypeJpaRepository extends JpaRepository<TicketType, String> {
    List<TicketType> findByIncludeWorkshopFalse();
}
