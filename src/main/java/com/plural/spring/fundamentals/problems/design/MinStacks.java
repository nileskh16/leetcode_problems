package com.plural.spring.fundamentals.problems.design;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinStacks {

    private final Deque<Integer> stack;
    private final Queue<Integer> queue;

    public MinStacks() {
        stack = new LinkedList<>();
        queue = new PriorityQueue<>(Integer::compareTo);
    }

    public void push(int val) {
        stack.push(val);
        queue.add(val);
    }

    public void pop() {
        int removed = stack.pop();
        queue.remove(removed);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}
