package com.plural.spring.fundamentals.problems.arrays;

/*
Link -
 */

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));
        List<int[]> ans = new ArrayList<>();
        Collections.addAll(queue, intervals);
        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            int tempMin = arr[0];
            int tempMax = arr[1];

            if (max != Integer.MIN_VALUE && tempMin > max) {
                ans.add(new int[]{min, max});
                min = tempMin;
                max = tempMax;
            } else {
                min = Math.min(tempMin, min);
                max = Math.max(tempMax, max);
            }
        }
        ans.add(new int[]{min, max});
        return ans.toArray(new int[][]{});
    }
}
