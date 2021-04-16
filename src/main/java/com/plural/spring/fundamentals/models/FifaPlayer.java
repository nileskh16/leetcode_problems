package com.plural.spring.fundamentals.models;

import com.plural.spring.fundamentals.annotations.JsonFieldInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FifaPlayer {

    @JsonFieldInclude("playerName")
    public String name;

    @JsonFieldInclude("country")
    public String country;

    @JsonFieldInclude
    public int age;

    public FifaPlayer() {
        super();
    }
}
