package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketPriceJpaRepository extends JpaRepository<TicketPrice, Long> {

    @Query("select tp from TicketPrice tp where tp.price < :price and tp.ticketType.includeWorkshop=true")
    List<TicketPrice> getTicketPricesBelowPriceWithWorkshopOn(@Param("price") Float price);

    @Query("select tp from TicketPrice tp where tp.price > :price and tp.pricingCategory.code=:code")
    List<TicketPrice> getTicketPricesAbovePriceWithPriceCategory(@Param("price") Float price, @Param("code") String code);
}
