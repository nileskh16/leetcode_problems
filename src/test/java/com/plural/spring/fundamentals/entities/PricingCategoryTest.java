package com.plural.spring.fundamentals.entities;

import com.plural.spring.fundamentals.repositories.PricingCategoryJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PricingCategoryTest {

    @Autowired
    private PricingCategoryJpaRepository repository;

    @Test
    public void testJpaNamed() {
        List<PricingCategory> pricingCategories = repository.getByCode("E");
        Assertions.assertEquals(1, pricingCategories.size());
    }
}
