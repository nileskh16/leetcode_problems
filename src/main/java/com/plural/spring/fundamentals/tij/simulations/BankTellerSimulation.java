package com.plural.spring.fundamentals.tij.simulations;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BankTellerSimulation {

    static class Customer {
        private final int servingTime;

        Customer(int servingTime) {
            this.servingTime = servingTime;
        }

        public int getServingTime() {
            return servingTime;
        }

        @Override
        public String toString() {
            return String.format(" %d ", servingTime);
        }
    }

    static class CustomerLine extends ArrayBlockingQueue<Customer> {
        public CustomerLine(int maxBlockSize) {
            super(maxBlockSize);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("CustomerLine ->");
            for (Customer customer : this) {
                sb.append(customer);
            }
            return sb.toString();
        }
    }

    static class CustomerGenerator implements Runnable {

        private final CustomerLine customers;
        private final int maxCustomers;
        private final static Random rand = new Random(45);
        private final AtomicInteger count = new AtomicInteger(0);

        public CustomerGenerator(CustomerLine customers, int maxCustomers) {
            this.customers = customers;
            this.maxCustomers = maxCustomers;
        }

        public void generateCustomer() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
            customers.put(new Customer(rand.nextInt(1000)));
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted() && count.incrementAndGet() < maxCustomers) {
                    generateCustomer();
                }
            } catch (InterruptedException exception) {
                System.out.println("Customer generator interrupted");
            }
            System.out.println("Customer generator terminated");
        }
    }

    static class Teller implements Runnable, Comparable<Teller> {

        private static int counter = 0;
        private boolean isServingCustomer = true;
        private final CustomerLine customers;
        private int customersServed = 0;
        private final int id = ++counter;

        Teller(CustomerLine customers) {
            this.customers = customers;
        }

        public synchronized void serveCustomer() {
            assert !isServingCustomer;
            isServingCustomer = true;
            notifyAll();
        }

        public synchronized void doSomethingElse() {
            customersServed = 0;
            isServingCustomer = false;
        }

        @Override
        public int compareTo(Teller o) {
            return Integer.compare(customersServed, o.customersServed);
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    Customer customer = customers.take();
                    System.out.printf("%s is serving customer %s %n", this, customer);
                    TimeUnit.MILLISECONDS.sleep(customer.getServingTime());

                    synchronized (this) {
                        customersServed++;
                        while (!isServingCustomer) wait();
                    }
                }
            } catch (InterruptedException interruptedException) {
                System.out.println("Teller interrupted");
            }
        }

        @Override
        public String toString() {
            return "Teller " + id;
        }
    }

    private static class TellerManager implements Runnable {

        private final int adjustmentPeriod;
        private final ExecutorService exec;
        private final CustomerLine customers;
        private final PriorityQueue<Teller> workingTellers;
        private final Queue<Teller> nonWorkingTellers;
        private static volatile boolean shouldShutDown = false;

        public TellerManager(int adjustmentPeriod, ExecutorService executorService, CustomerLine customers) {
            this.adjustmentPeriod = adjustmentPeriod;
            this.customers = customers;
            exec = executorService;
            workingTellers = new PriorityQueue<>();
            nonWorkingTellers = new LinkedList<>();
            Teller teller = new Teller(customers);
            workingTellers.add(teller);
            exec.execute(teller);
        }

        private void adjustTellers() {
            if (customers.size() / workingTellers.size() > 2) {
                Teller teller;
                if (nonWorkingTellers.size() > 0) {
                    teller = nonWorkingTellers.remove();
                    teller.serveCustomer();
                    workingTellers.offer(teller);
                } else {
                    teller = new Teller(customers);
                    exec.execute(teller);
                    workingTellers.add(teller);
                }
                return;
            }
            if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2) {
                Teller teller = workingTellers.poll();
                reAssignTeller(teller);
            }
            if (customers.size() == 0) {
                System.out.println("Served all customers");
                while (workingTellers.size() > 1) {
                    reAssignTeller(workingTellers.poll());
                }
                shouldShutDown = true;
            }
        }

        private void reAssignTeller(Teller teller) {
            teller.doSomethingElse();
            nonWorkingTellers.offer(teller);
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                    System.out.println(customers);
                    adjustTellers();
                    if (shouldShutDown) break;
                }
            } catch (InterruptedException interruptedException) {
                System.out.println("Teller manager interrupted");
            }
        }
    }

    public void runBankSimulator() {
        final int MAX_SIZE = 2;
        final int MAX_CUSTOMERS = 11;
        final int ADJUSTMENT_PERIOD = 1000;
        ExecutorService service = Executors.newFixedThreadPool(MAX_SIZE);
        CustomerLine customers = new CustomerLine(MAX_SIZE);
        service.execute(new CustomerGenerator(customers, MAX_CUSTOMERS));
        service.execute(new TellerManager(ADJUSTMENT_PERIOD, service, customers));
        service.shutdown();
    }
}