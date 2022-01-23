package com.plural.spring.fundamentals.contests.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MinTrainPlatforms {

    public static void main(String[] args) {

    }

    public int numOfPlatforms(int[] arr, int[] dep) {
        if (arr.length == 0 || arr.length != dep.length) return 0;
        int ans = 1, index = 1, start = arr[0], end = dep[0];
        List<Integer> parked = new ArrayList<>();
        parked.add(end);
        while (index < arr.length) {
            int s = arr[index], e = dep[index];
            boolean isAvailable = false;
            for (int i = 0; i < parked.size(); i++) {
                if (parked.get(i) < s) {
                    parked.set(i, e);
                    isAvailable = true;
                    break;
                }
            }
            if (!isAvailable) {
                parked.add(e);
                ans++;
            }
            index++;
        }

        return ans;
    }
}
