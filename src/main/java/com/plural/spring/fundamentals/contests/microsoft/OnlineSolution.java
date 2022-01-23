package com.plural.spring.fundamentals.contests.microsoft;

public class OnlineSolution {

    public int goodNumber(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length, leftSum = 0, rightSum = arr[n - 1];
        for (int num : arr) leftSum += num;
        int i = n - 1;
        while (i >= 0) {
            int num = arr[i];
            if (i > 0) leftSum -= num;
            if (leftSum == num && rightSum == num) return num;
            if (i < n - 1) rightSum += num;
            i--;
        }
        return -1;
    }
}
