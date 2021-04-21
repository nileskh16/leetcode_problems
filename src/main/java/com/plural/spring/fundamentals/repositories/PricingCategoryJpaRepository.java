package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.PricingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingCategoryJpaRepository extends JpaRepository<PricingCategory, String> {
}