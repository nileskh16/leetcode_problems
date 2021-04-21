package com.plural.spring.fundamentals.entities;

import com.plural.spring.fundamentals.repositories.PricingCategoryJpaRepository;
import com.plural.spring.fundamentals.repositories.TicketPriceJpaRepository;
import com.plural.spring.fundamentals.repositories.TicketTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
public class TicketPriceTest {

    @Autowired
    private TicketPriceJpaRepository repository;

    @Autowired
    private TicketTypeRepository ticketRepository;

    @Autowired
    private PricingCategoryJpaRepository priceRepository;

    @Test
    public void testGetTicketPrice() {
        TicketPrice saveTicketPrice = repository.findById(1L).orElse(null);
        Assertions.assertNotNull(saveTicketPrice);
        Assertions.assertEquals(800, saveTicketPrice.getPrice());
    }

    @Test
    @Transactional
    public void testSaveAndDelete() {
        TicketPrice tp = new TicketPrice();
        TicketType premiumType = ticketRepository.getOne("P");
        PricingCategory category = priceRepository.getOne("E");
        Assertions.assertNotNull(premiumType);
        Assertions.assertNotNull(category);
        tp.setPrice(900.50f);
        tp.setTicketType(premiumType);
        tp.setPricingCategory(category);
        tp = repository.saveAndFlush(tp);
        Assertions.assertNotNull(tp);
        TicketPrice savedTp = repository.getOne(tp.getId());
        Assertions.assertEquals(900.50f, savedTp.getPrice());
        repository.deleteById(tp.getId());
        Assertions.assertNull(repository.findById(tp.getId()).orElse(null));
    }
}