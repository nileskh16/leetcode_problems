package com.plural.spring.fundamentals.tij.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {

    private Chopstick left;
    private Chopstick right;
    private int id;
    private int factor;
    private static final Random rand = new Random(47);

    public Philosopher(Chopstick left, Chopstick right, int id, int factor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.factor = factor;
    }

    public void think() throws InterruptedException {
        if (factor == 0) return;
        TimeUnit.MILLISECONDS.wait(rand.nextInt(factor * 250));
    }

    public void eat() throws InterruptedException {
        System.out.println(this + " picking the left stick");
        left.take();

        System.out.println(this + " picking the right stick");
        right.take();
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " is thinking");
                think();
                System.out.println(this + " is about to eat now");
                eat();
                TimeUnit.MILLISECONDS.wait(1000);
                System.out.println(this + " is thinking again");
                think();
                left.drop();
                right.drop();
            }
        } catch (InterruptedException exception) {

        }
    }

    @Override
    public String toString() {
        return "Philosopher -> " + id;
    }
}
