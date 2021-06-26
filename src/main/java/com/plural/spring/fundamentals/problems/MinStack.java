package com.plural.spring.fundamentals.problems;

import com.plural.spring.fundamentals.utils.StackNode;

import java.util.PriorityQueue;

public class MinStack {

    StackNode top;
    PriorityQueue<Integer> queue;

    public MinStack() {
        top = null;
        queue = new PriorityQueue<>();
    }

    public void push(int val) {
        StackNode tempNode = new StackNode(val);
        tempNode.next = top;
        top = tempNode;
        queue.add(val);
    }

    public void pop() {
        if (top != null) {
            queue.remove(top.val);
            top = top.next;
        }
    }

    public int top() {
        return top != null ? top.val : -1;
    }

    public int getMin() {
        return !queue.isEmpty() ? queue.peek() : -1;
    }
}
