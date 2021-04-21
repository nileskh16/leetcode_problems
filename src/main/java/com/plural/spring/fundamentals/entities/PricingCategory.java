package com.plural.spring.fundamentals.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PRICING_CATEGORIES")
@Getter
@Setter
@NoArgsConstructor
public class PricingCategory {

    @Id
    @Column(name = "CATEGORY_CODE")
    private String code;

    @Column(name = "CATEGORY_NAME")
    private String name;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @OneToMany(mappedBy = "pricingCategory")
    @JsonIgnore
    private List<TicketPrice> ticketPriceList;
}
