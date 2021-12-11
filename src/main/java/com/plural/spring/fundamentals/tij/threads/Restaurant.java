package com.plural.spring.fundamentals.tij.threads;

import com.plural.spring.fundamentals.tij.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Restaurant implements Runnable {

    private final List<Waiter> waiters;
    private final List<Chef> chefs;
    private final BlockingQueue<Order> orders;
    private final ExecutorService service;
    private final Random random;

    public Restaurant(int noOfWaiters, int noOfChefs, ExecutorService service) {
        waiters = new ArrayList<>(noOfWaiters);
        chefs = new ArrayList<>(noOfChefs);
        orders = new LinkedBlockingQueue<>();
        this.service = service;
        random = new Random(45);

        for (int i = 0; i < noOfWaiters; i++) {
            Waiter waiter = new Waiter(this);
            waiters.add(waiter);
            this.service.execute(waiter);
        }

        for (int i = 0; i < noOfChefs; i++) {
            Chef chef = new Chef(this);
            chefs.add(chef);
            this.service.execute(chef);
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                Customer customer = new Customer(waiters.get(random.nextInt(waiters.size())));
                service.execute(customer);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    public BlockingQueue<Order> getOrders() {
        return orders;
    }
}
