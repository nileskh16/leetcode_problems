package com.plural.spring.fundamentals.leetcodes.july_21;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private final Queue<Integer> maxHeap;
    private final Queue<Integer> minHeap;


    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }
}
