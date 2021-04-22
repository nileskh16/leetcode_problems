package com.plural.spring.fundamentals.entities;

import com.plural.spring.fundamentals.repositories.PricingCategoryJpaRepository;
import com.plural.spring.fundamentals.repositories.TicketPriceJpaRepository;
import com.plural.spring.fundamentals.repositories.TicketTypeJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class TicketPriceTest {

    @Autowired
    private TicketPriceJpaRepository repository;

    @Autowired
    private TicketTypeJpaRepository ticketRepository;

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

    @Test
    public void testJpaQl() {
        List<TicketPrice> prices = repository.getTicketPricesBelowPriceWithWorkshopOn(5000.0F);
        Assertions.assertEquals(3, prices.size());
        prices = repository.getTicketPricesAbovePriceWithPriceCategory(500.0F, "E");
        Assertions.assertEquals(1, prices.size());
    }
}
