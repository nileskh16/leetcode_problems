package com.plural.spring.fundamentals.problems.strings;

public class StringCompression {

    public int compress(char[] chars) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                sb.append(chars[i - 1]);
                if (count > 1) sb.append(count);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(chars[chars.length - 1]);
        if (count > 1) sb.append(count);
        char[] dup = sb.toString().toCharArray();
        chars = new char[dup.length];
        System.arraycopy(dup, 0, chars, 0, dup.length);
        return sb.length();
    }
}
