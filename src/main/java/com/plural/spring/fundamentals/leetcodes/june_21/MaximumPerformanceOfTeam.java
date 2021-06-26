package com.plural.spring.fundamentals.leetcodes.june_21;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumPerformanceOfTeam {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long res = 0;
        long totalSpeed = 0;
        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        Queue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a - b);

        for (int[] engineer : engineers) {
            if (queue.size() == k) totalSpeed -= queue.poll();
            queue.add(engineer[1]);
            totalSpeed += engineer[1];
            res = Math.max(res, totalSpeed * engineer[0]);
        }

        return (int) (res % (long)(1e9 + 7));
    }
}
