package com.plural.spring.fundamentals.models;

public class Passenger {

    private final int id;

    public Passenger(int id) {
        this.id = id;
    }

    public int getPassengerId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person id: " + id;
    }
}
