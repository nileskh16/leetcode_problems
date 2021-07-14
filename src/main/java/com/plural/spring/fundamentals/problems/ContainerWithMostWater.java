package com.plural.spring.fundamentals.problems;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            area = Math.max(area, ((j - i) * Math.min(height[i], height[j])));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return area;
    }
}
