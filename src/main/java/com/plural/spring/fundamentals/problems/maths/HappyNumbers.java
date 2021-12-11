package com.plural.spring.fundamentals.problems.maths;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {

    public boolean isHappy(int n) {
        Set<Integer> usedNumbers = new HashSet<>();
        while (n != 1) {
            int sumOfDigits = 0;
            int tempNumber = n;
            while (tempNumber != 0) {
                sumOfDigits += (tempNumber % 10) * (tempNumber % 10);
                tempNumber /= 10;
            }
            if (sumOfDigits == 1) return true;
            if (usedNumbers.contains(sumOfDigits)) return false;
            usedNumbers.add(sumOfDigits);
            n = sumOfDigits;
        }
        return true;
    }

    public boolean isHappyNum(int n) {
        int[] dp = new int[1001];
        int index = 1;
        while (index <= 1000) {
            dp[index] = 1;
            index *= 10;
        }
        while (n != 1) {
            int sum = getSum(n);
            if (dp[sum] == 1) return true;
            if (dp[sum] == -1) return false;
            dp[n] = -1;
            n = sum;
        }
        return true;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += (rem * rem);
            num /= 10;
        }
        return sum;
    }
}
