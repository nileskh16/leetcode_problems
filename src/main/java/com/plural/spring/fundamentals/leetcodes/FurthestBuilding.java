package com.plural.spring.fundamentals.leetcodes;

import java.util.PriorityQueue;

public class FurthestBuilding {

    public static void main(String[] args) {
        int[] array = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println("The furthest building is " + new FurthestBuilding().furthestIndex(array, bricks, ladders));
        runPQ();
    }

    public int furthestIndex(int[] array, int bricks, int ladders) {
        return iterate(array, bricks, ladders);
    }

    private int iterate(int[] array, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = array.length - 1;

        for (int i=0; i<len; i++) {
            int diff = array[i+1] - array[i];
            if (diff > 0) {
                if (ladders > 0) {
                    pq.add(diff);
                    ladders -= 1;
                } else if (pq.size() > 0 && diff > pq.peek()) {
                    pq.add(diff);
                    bricks -= pq.poll();
                } else bricks -= diff;
                if (bricks < 0) return i;
            }
        }
        return len;
    }

    private int traverse(int[] array, int bricks, int ladders, int currentIndex) {
        if ((array.length - 1) == currentIndex) return currentIndex;
        int nextElement = array[currentIndex + 1];
        int currentElement = array[currentIndex];
        int optimumIndex = currentIndex;
        int opt;

        if (nextElement > currentElement) {
            if (bricks > (nextElement - currentElement)) {
                opt = traverse(array, bricks - (nextElement - currentElement), ladders, currentIndex+1);
                if (opt > optimumIndex) optimumIndex = opt;
            }
            if (ladders > 0) {
                opt = traverse(array, bricks, ladders - 1, currentIndex+1);
                if (opt > optimumIndex) optimumIndex = opt;
            }
        } else {
            opt = traverse(array, bricks, ladders, currentIndex + 1);
            if (opt > optimumIndex) optimumIndex = opt;
        }
        return optimumIndex;
    }

    private static void runPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(45);
        pq.add(1);
        pq.add(100);
        pq.add(24);
        pq.add(0);
        pq.add(7);
        pq.add(11);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
