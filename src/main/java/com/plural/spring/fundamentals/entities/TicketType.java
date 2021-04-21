package com.plural.spring.fundamentals.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TICKET_TYPES")
@Getter
@Setter
@NoArgsConstructor
public class TicketType {

    @Id
    @Column(name = "TICKET_TYPE_CODE")
    private String code;

    @Column(name = "TICKET_TYPE_NAME")
    private String name;

    @Column(name = "TICKET_TYPE_DESCRIPTION")
    private String description;

    @Column(name = "INCLUDE_WORKSHOP")
    private boolean includeWorkshop;

    @OneToMany(mappedBy = "ticketType")
    @JsonIgnore
    private List<TicketPrice> ticketPriceList;
}