package com.plural.spring.fundamentals.tij.utils;

public class Chopstick {
    private boolean isTaken = false;

    public synchronized void take() throws InterruptedException {
        while (isTaken) {
            wait();
        }
        isTaken = true;
    }

    public synchronized void drop() {
        isTaken = false;
        notifyAll();
    }
}
