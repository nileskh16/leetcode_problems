package com.plural.spring.fundamentals.contests.apple;

import java.util.*;

public class AppMergeIntervals {

    public int[][] merge(int[][] intervals) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));
        List<int[]> list = new ArrayList<>();
        int low, high;
        queue.addAll(Arrays.asList(intervals));
        int[] firstInterval = queue.peek();
        low = firstInterval[0]; high = firstInterval[1];

        while (!queue.isEmpty()) {
            int[] interval = queue.poll();
            int l = interval[0], h = interval[1];
            if (l > high) {
                int[] ans = new int[2];
                ans[0] = low; ans[1] = high;
                list.add(ans);
                low = l; high = h;
            } else {
                low = Math.min(low, l);
                high = Math.max(high, h);
            }
        }
        list.add(new int[]{low, high});
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
}
