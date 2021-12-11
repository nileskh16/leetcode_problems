package com.plural.spring.fundamentals.problems.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int firstTop = Integer.MAX_VALUE;
        int secondTop = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= firstTop) {
                firstTop = num;
            } else if (num <= secondTop) {
                secondTop = num;
            } else return true;
        }

        return false;
    }

    public void runClass() {
        Set<Integer> map = new HashSet<>(5);
        for (int i = 0; i < 5; i++) {
            map.add(i);
        }
        Map<Integer, Integer> set = new HashMap();
        int i = 0;
        while (!map.isEmpty()) {
            map.add(i++);
        }
    }

    public static void main(String[] args) {
        int i = 5;
        i = i++ + ++i - i-- - --i;
        System.out.println(i);
    }

    static String process(String a, String b, String xchange) {
        xchange = b + " " + a;

        return xchange;
    }
}
