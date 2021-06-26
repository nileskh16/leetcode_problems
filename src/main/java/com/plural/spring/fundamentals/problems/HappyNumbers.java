package com.plural.spring.fundamentals.problems;

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
}
