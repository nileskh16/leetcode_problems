package com.plural.spring.fundamentals.tij.models;

import com.plural.spring.fundamentals.tij.threads.Customer;
import com.plural.spring.fundamentals.tij.threads.Waiter;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final int orderId;
    private String status;
    private final List<String> items;
    private final Customer customer;
    private final Waiter waiter;

    public Order(int orderId, Customer customer, Waiter waiter) {
        this.orderId = orderId;
        this.waiter = waiter;
        this.customer = customer;
        items = new ArrayList<>();
    }

    public void addItem(String itemName) {
        this.items.add(itemName);
    }

    public Customer getCustomer() { return customer; }

    public Waiter getWaiter() { return waiter; }

    public int getOrderId() { return orderId; }
}
