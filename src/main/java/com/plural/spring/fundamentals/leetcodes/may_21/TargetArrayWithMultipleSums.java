package com.plural.spring.fundamentals.leetcodes.may_21;

import java.util.*;

public class TargetArrayWithMultipleSums {

    public static void main(String[] args) {
        TargetArrayWithMultipleSums targetArray = new TargetArrayWithMultipleSums();
        int[] target = {9, 3, 5};
        System.out.println(targetArray.isPossible(target));
    }

    public boolean isPossible(int[] target) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int num : target) {
            sum += num;
            queue.add(num);
        }

        while (queue.peek() != 1) {
            int num = queue.poll();
            sum -= num;
            if (num <= sum || sum < 1) return false;
            num %= sum;
            sum += num;
            queue.add(num);
        }
        return true;
    }

    private int sumOfArray(int[] target, int excludeIndex) {
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            if (i != excludeIndex) {
                sum += target[i];
            }
        }
        return sum;
    }

    private Map<Integer, Integer> getMaxNumMap(int[] target) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = 0;
        int maxIndex = -1;
        for (int i = 0; i < target.length; i++) {
            if (maxNum < target[i]) {
                maxNum = target[i];
                maxIndex = i;
            }
        }
        map.put(maxNum, maxIndex);
        return map;
    }
}
