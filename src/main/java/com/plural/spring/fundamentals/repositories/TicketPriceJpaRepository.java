package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPriceJpaRepository extends JpaRepository<TicketPrice, Long> {
}
