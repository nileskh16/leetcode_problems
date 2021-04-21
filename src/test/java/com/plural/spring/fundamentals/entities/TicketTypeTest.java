package com.plural.spring.fundamentals.entities;

import com.plural.spring.fundamentals.repositories.TicketTypeJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TicketTypeTest {

    @Autowired
    private TicketTypeJpaRepository repository;

    @Test
    public void testJpaFalse() {
        List<TicketType> ticketTypesWithoutWorkshops = repository.findByIncludeWorkshopFalse();
        Assertions.assertEquals(2, ticketTypesWithoutWorkshops.size());
    }
}
