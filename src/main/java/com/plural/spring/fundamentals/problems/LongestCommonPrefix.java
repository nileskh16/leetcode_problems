package com.plural.spring.fundamentals.problems;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        int index = 0;
        String ref = strs[0];
        boolean found = false;
        while (!found) {
            if (index >= ref.length()) break;
            char ch = ref.charAt(index);
            for (int cursor = 1; cursor < strs.length; cursor++) {
                String temp = strs[cursor];
                if (index >= temp.length()) return temp;
                if (ch != strs[cursor].charAt(index)) {
                    found = true;
                    break;
                }
            }
            if (!found) index++;
        }
        return index == 0 ? "" : ref.substring(0, index);
    }
}
