package com.plural.spring.fundamentals.problems.maths;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int taskNbr = tasks.length;
        int res = 0;
        PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.coolDown == n2.coolDown) {
                    return n2.fre - n1.fre;
                } else {
                    return n1.coolDown - n2.coolDown;
                }
            }
        });
        int[] taskCnt = new int[26];
        for (int i = 0; i < taskNbr; i++) {
            taskCnt[tasks[i] - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (taskCnt[i] > 0) {
                pq.offer(new Node((i + 'A') + "", taskCnt[i]));
            }
        }
        while (pq.size() > 0) {
            Node temp = pq.poll();
            if (temp.fre <= 0) {
                continue;
            }
            if (temp.coolDown <= 0) {
                temp.fre--;
                temp.coolDown = n;
            } else {
                temp.coolDown--;
            }
            reHeapify(pq);
            res++;
            if (temp.fre > 0) {
                pq.offer(temp);
            }
        }
        return res;
    }

    public void reHeapify(PriorityQueue<Node> pq) {
        List<Node> l = new LinkedList(pq);
        pq.clear();
        l.stream().forEach(n -> {
            if (n.coolDown > 0) {
                n.coolDown--;
            }
            pq.offer(n);
        });
    }

    private static class Node {
        public String letter;
        public int fre;
        public int coolDown = 0;

        public Node(String letter, int fre) {
            this.letter = letter;
            this.fre = fre;
        }
    }
}
