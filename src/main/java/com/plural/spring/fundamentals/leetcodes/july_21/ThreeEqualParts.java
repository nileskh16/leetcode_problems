package com.plural.spring.fundamentals.leetcodes.july_21;

/*
Date: 07/18/2021
Problem Statement:
You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such that all of these parts represent the same binary value.

If it is possible, return any [i, j] with i + 1 < j, such that:

    arr[0], arr[1], ..., arr[i] is the first part,
    arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
    arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
    All three parts have equal binary values.

If it is not possible, return [-1, -1].
Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents 6 in decimal, not 3.
Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
 */

public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int noOfOnes = 0;
        for (int i : arr) if (i == 1) noOfOnes++;

        if (noOfOnes == 0) return new int[]{0, 2};

        if (noOfOnes % 3 != 0) return new int[]{-1, -1};

        int p1 = 0, p2 = 0, p3 = 0;
        int oneCount = 0;
        int unit = noOfOnes / 3;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (oneCount == 0) p1 = i;
                else if (oneCount == unit) p2 = i;
                else if (oneCount == 2 * unit) p3 = i;
                oneCount++;
            }
        }

        while (p3 < arr.length) {
            if (arr[p1] != arr[p2] || arr[p2] != arr[p3]) return new int[]{-1, -1};
            p1++;
            p2++;
            p3++;
        }

        return new int[]{p1 - 1, p2};
    }
}
