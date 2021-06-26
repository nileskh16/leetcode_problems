package com.plural.spring.fundamentals.leetcodes.may_21;

public class DeciBinaryNumbers {

    public int minPartitions(String n) {
        char max = '0';
        for (char ch : n.toCharArray()) {
            if (max < ch) max = ch;
        }
        return max - '0';
    }
}
