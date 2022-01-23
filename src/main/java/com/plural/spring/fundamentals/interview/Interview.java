package com.plural.spring.fundamentals.interview;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Interview {

    public static void main(String[] args) {
        findMovieLength();
    }

    private static List<Integer> findPeaks(int[] numberOfPatients) {
        List<Integer> answer = new ArrayList<>(numberOfPatients.length);
        if (numberOfPatients.length == 0) return answer;
        List<Integer> unique = uniqueElements(numberOfPatients);
        for (int i = 0; i < unique.size(); i++) {
            int prev = i == 0 ? i : i - 1;
            int next = i == unique.size() - 1 ? unique.size() - 1 : i + 1;
            if (unique.get(i) > unique.get(prev) && unique.get(i) > unique.get(next)) {
                answer.add(numberOfPatients[i]);
            }
        }
        return answer;
    }

    private static List<Integer> uniqueElements(int[] numOfPatients) {
        List<Integer> arr = new ArrayList<>(numOfPatients.length);
        for (int num : numOfPatients) {
            if (!arr.contains(num)) arr.add(num);
        }
        return arr;
    }

    private static void sortObjects() {
        Object[] arr = new Object[]{
                new Integer(7),
                new String("foo"),
                new Integer(15),
                new Boolean(false)};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }

    private static void testInheritance() {
        class A {
        }
        ;
        class B extends A {
        }
        ;

        A[] arrA = new A[10];
        B[] arrB = new B[20];
        arrA = arrB;
        arrB = (B[]) arrA;

        arrA = new A[15];
    }

    private static void useStreams() {
        Stream<String> words = Stream.of("One", "two", "three");
        int ans = words.mapToInt(String::length).reduce(0, (int l1, int l2) -> l1 + l2);
        System.out.println(ans);
    }

    private static void thirdHighest() {
        int[] input = new int[]{78, 43, 23, 80, 15, 99, 21, 87, 71, 56, 32};
        int first = input[0], second = input[0], third = input[0];

        for (int i = 1; i < input.length; i++) {
            int num = input[i];
            if (first < num) {
                third = second;
                second = first;
                first = num;
            } else if (num < first && num > second) {
                third = second;
                second = num;
            } else if (num < first && num < second && num > third) {
                third = num;
            }
        }

        System.out.println(String.format("Top 3: %d, %d, %d", first, second, third));
    }

    private static class Counter {
        private static int count = 1;

        public synchronized void printCount(int threadId, int length) throws InterruptedException {
            if (count % length == threadId || (threadId == length && count % length == 0)) {
                System.out.printf("Thread %s has count: %d%n", Thread.currentThread().getName(), count);
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    private static class Printer implements Runnable {
        private final int threadId;
        private final Counter counter;
        private final int numOfThreads;

        public Printer(int threadId, int numOfThreads, Counter counter) {
            this.counter = counter;
            this.threadId = threadId;
            this.numOfThreads = numOfThreads;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    counter.printCount(threadId, numOfThreads);
                    TimeUnit.SECONDS.sleep(3);
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void initiateAndRunThreads(int count) {
        try {
            Thread[] threads = new Thread[count];
            final Counter counter = new Counter();
            for (int i = 0; i < count; i++) {
                threads[i] = new Thread(new Printer(i + 1, count, counter), String.format("Thread - %d", i + 1));
                threads[i].start();
            }
            for (Thread thread : threads) thread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private static void findMovieLength() {
        int[] movies = new int[]{27, 1, 10, 39, 12, 52, 32, 67, 76};
        int flightDuration = 77;
        Queue<int[]> ans = new PriorityQueue<>((a, b) -> {
            int firstMax = Math.max(a[0], a[1]), secondMax = Math.max(b[0], b[1]);
            return Integer.compare(secondMax, firstMax);
        });
        Map<Integer, Integer> cache = new HashMap<>();
        for (int movie : movies) {
            if (movie < flightDuration && movie >= 0) {
                int diff = flightDuration - movie;
                if (cache.getOrDefault(movie, -1) == diff) {
                    ans.add(new int[]{diff, movie});
                    continue;
                }
                cache.put(diff, movie);
            }
        }
        if (!ans.isEmpty()) {
            int[] finalMovie = ans.poll();
            System.out.printf("Pair found: %d -> %d%n", finalMovie[0], finalMovie[1]);
        } else {
            System.out.println("No such pair found");
        }
    }
}
