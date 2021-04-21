package com.plural.spring.fundamentals.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TICKET_PRICES")
@Getter
@Setter
@NoArgsConstructor
public class TicketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TICKET_PRICE")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "TICKET_TYPE_CODE", nullable = false, updatable = false)
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "PRICING_CAT_CODE", nullable = false, updatable = false)
    private PricingCategory pricingCategory;
}
