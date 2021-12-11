package com.plural.spring.fundamentals.tij.threads;

import com.plural.spring.fundamentals.tij.models.Order;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
    private final Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Order order = restaurant.getOrders().take();
                System.out.println(String.format("Chef %s is working on order with %d", Thread.currentThread().getName(), order.getOrderId()));
                TimeUnit.MILLISECONDS.sleep(2000);
                order.getWaiter().completedOrders.add(order);
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
