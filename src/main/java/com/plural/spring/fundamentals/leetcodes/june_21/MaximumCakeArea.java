package com.plural.spring.fundamentals.leetcodes.june_21;

import java.util.Arrays;

public class MaximumCakeArea {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxHorizontalDiff = 0;
        int maxVerticalDiff = 0;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        for (int i = 0; i <= verticalCuts.length; i++) {
            int left = i == 0 ? 0 : verticalCuts[i - 1];
            int right = i == verticalCuts.length ? w : verticalCuts[i];
            maxVerticalDiff = Math.max(maxVerticalDiff, (right - left));
        }

        for (int i = 0; i <= horizontalCuts.length; i++) {
            int lower = i == 0 ? 0 : horizontalCuts[i - 1];
            int upper = i == horizontalCuts.length ? h : horizontalCuts[i];
            maxHorizontalDiff = Math.max(maxHorizontalDiff, (upper - lower));
        }

        return (int)((long)maxHorizontalDiff * maxVerticalDiff % 1000000007);
    }
}
