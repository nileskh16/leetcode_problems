package com.plural.spring.fundamentals.leetcodes.june_21;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumUnitsOnTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] box : boxTypes) queue.add(box);
        int units = 0;

        while (!queue.isEmpty()) {
            int[] box = queue.poll();
            units += ((Math.min(truckSize, box[0])) * box[1]);
            truckSize -= box[0];
            if (truckSize <= 0) break;
        }
        return units;
    }
}
