package com.plural.spring.fundamentals.tij.threads;

import com.plural.spring.fundamentals.tij.models.Order;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Waiter implements Runnable {

    private final Restaurant restaurant;
    public final BlockingQueue<Order> completedOrders;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
        completedOrders = new LinkedBlockingQueue<>();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Order order = completedOrders.poll();
            if (order != null) {
                System.out.println(String.format("Waiter %s is delivering an order with id %d", Thread.currentThread().getName(), order.getOrderId()));
                order.getCustomer().deliverOrder(order);
            }
        }
    }

    public void placeOrder(Order order) {
        System.out.println(String.format("Waiter %s is placing an order with id %d", Thread.currentThread().getName(), order.getOrderId()));
        restaurant.getOrders().add(order);
    }
}
