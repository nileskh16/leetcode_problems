package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTypeRepository extends JpaRepository<TicketType, String> {
}
