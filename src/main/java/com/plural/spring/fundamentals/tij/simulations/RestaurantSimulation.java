package com.plural.spring.fundamentals.tij.simulations;

import com.plural.spring.fundamentals.tij.threads.Restaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RestaurantSimulation {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(5, 2, service);
        service.execute(restaurant);
    }
}
