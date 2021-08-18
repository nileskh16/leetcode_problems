package com.plural.spring.fundamentals.tij.demo;

import com.plural.spring.fundamentals.tij.simulations.BankTellerSimulation;
import com.plural.spring.fundamentals.tij.utils.Chopstick;
import com.plural.spring.fundamentals.tij.utils.Philosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainDemo {

    public static void main(String[] args) {
        runBankSimulator();
    }

    private static void runDiningPhilosophers() {
        int size = 5;
        int factor = 5;
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < size - 1; i++) {
            service.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, factor));
        }
        service.execute(new Philosopher(sticks[0], sticks[size - 1], size - 1, factor));
        try {
            TimeUnit.SECONDS.wait(5);
        } catch (InterruptedException exception) {

        }
        service.shutdown();
    }

    private static void runBankSimulator() {
        BankTellerSimulation simulation = new BankTellerSimulation();
        simulation.runBankSimulator();
    }
}
