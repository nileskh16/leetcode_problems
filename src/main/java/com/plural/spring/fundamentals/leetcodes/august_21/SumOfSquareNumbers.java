package com.plural.spring.fundamentals.leetcodes.august_21;

import java.util.HashMap;
import java.util.Map;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        Map<Integer, Integer> map = new HashMap<>((int) Math.sqrt(c));
        for (int i = 0; i <= Math.sqrt(c); i++) {
            Integer sqr = i * i;
            int diff = c - sqr;
            if (diff == sqr || sqr.equals(map.get(diff))) return true;
            map.put(sqr, diff);
        }
        return false;
    }
}
