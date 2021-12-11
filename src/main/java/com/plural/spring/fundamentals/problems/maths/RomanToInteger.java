package com.plural.spring.fundamentals.problems.maths;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> store = new HashMap<>(7);
        store.put('I', 1);
        store.put('V', 5);
        store.put('X', 10);
        store.put('L', 50);
        store.put('C', 100);
        store.put('D', 500);
        store.put('M', 1000);

        int i = 0;
        int sum = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            char next = i != s.length() - 1 ? s.charAt(i + 1) : 'O';
            int value = 0;
            switch (c) {
                case 'I':
                    if (next == 'V' || next == 'X') {
                        value = store.get(next) - store.get(c);
                        i += 2;
                    } else {
                        value = store.get(c);
                        i++;
                    }
                    break;
                case 'X':
                    if (next == 'L' || next == 'C') {
                        value = store.get(next) - store.get(c);
                        i += 2;
                    } else {
                        value = store.get(c);
                        i++;
                    }
                    break;
                case 'C':
                    if (next == 'D' || next == 'M') {
                        value = store.get(next) - store.get(c);
                        i += 2;
                    } else {
                        value = store.get(c);
                        i++;
                    }
                    break;
                case 'D':
                case 'L':
                case 'V':
                case 'M':
                    value = store.get(c);
                    i++;
                    break;
            }
            sum += value;
        }
        return sum;
    }
}
