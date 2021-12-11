package com.plural.spring.fundamentals.tij.models;

public class Region {

    private final String name;
    private final String country;
    private final long id;

    public Region(String name, String country, long id) {
        this.name = name;
        this.country = country;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}
