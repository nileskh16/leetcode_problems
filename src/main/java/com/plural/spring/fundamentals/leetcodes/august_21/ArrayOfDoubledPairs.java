package com.plural.spring.fundamentals.leetcodes.august_21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) cnt.put(x, cnt.getOrDefault(x, 0) + 1);

        for (int x : arr) {
            if (cnt.get(x) == 0) continue;
            if (x < 0 && x % 2 != 0) return false;
            int y = x > 0 ? x*2 : x/2;
            if (cnt.getOrDefault(y, 0) == 0) return false;
            cnt.put(x, cnt.get(x) - 1);
            cnt.put(y, cnt.get(y) - 1);
        }
        return true;
    }
}
