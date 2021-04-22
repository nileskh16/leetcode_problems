package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.PricingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PricingCategoryJpaRepository extends JpaRepository<PricingCategory, String> {

    @Query(name = "namedFindByCode")
    List<PricingCategory> getByCode(@Param("code") String code);
}