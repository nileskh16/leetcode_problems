package com.plural.spring.fundamentals.tij.threads;

import com.plural.spring.fundamentals.tij.models.Order;

public class Customer implements Runnable {

    private static int count = 0;

    private final int customerId = count++;
    private final Waiter waiter;

    public Customer(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void run() {
        System.out.println(String.format("Customer %s is placing an order with id %d.", Thread.currentThread().getName(), customerId));
        Order order = new Order(customerId, this, waiter);
        waiter.placeOrder(order);
    }

    public void deliverOrder(Order order) {
        System.out.println(String.format("Order with id %s is successfully delivered", order.getOrderId()));
    }
}
