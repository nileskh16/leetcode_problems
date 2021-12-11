package com.plural.spring.fundamentals.interview;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnerSolution implements Serializable {

    public static void main(String[] args) {
        Test2 test = new Test();
        test.show();
    }

    private static void runSolution() {
        A a = new B();
        System.out.println(a.x);
        printA();
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    static class A {
        int x = 40;

        protected void print() throws IOException {

        }
    }

    static class B extends A {
        int x = 50;

        @Override
        public void print() throws IOException {

        }
    }

    public static void printA() {
        try {
            printB();
        } catch (IOException e) {
            System.out.println("In class A");
        }
    }

    public static void printB() throws IOException {
        try {
            sayHello();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void sayHello() throws IOException {
        throw new IOException("Say Hello");
    }

    private static void runExecutor() {
        ExecutorService service;
        try {
            for (int i = 0; i < 4; i++) {
                service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
                for (int j = 0; j < 4; j++) {
                    service.execute(getRunnable(i));
                }
                TimeUnit.SECONDS.sleep(1);
                service.shutdown();
                service.awaitTermination(2, TimeUnit.SECONDS);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private static Runnable getRunnable(final int n) {
        return () -> {
            try {
                System.out.println(n);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        };
    }

    private static interface Test1 {
        void show();
    }

    private static interface Test2 {
        void show();
    }

    private static class Test implements Test1, Test2 {
        @Override
        public void show() {
            System.out.println("Show");
        }
    }
}
