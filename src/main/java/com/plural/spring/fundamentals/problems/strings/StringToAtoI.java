package com.plural.spring.fundamentals.problems.strings;

/*
Problem Statement:
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 */

public class StringToAtoI {

    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        boolean isNegative = false;
        int index = 0;
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        if (s.startsWith("-")) {
            isNegative = true;
            index = 1;
        } else if (s.startsWith("+")) {
            index = 1;
        }
        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < 48 || ch > 57) break;
            sb.append(ch);
        }

        String str = sb.toString();
        if (str.isEmpty()) return 0;
        int result = 0;
        try {
            result = Integer.parseInt(str);
            result = isNegative ? -result : result;
        } catch (NumberFormatException ex) {
            result = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return result;
    }
}
