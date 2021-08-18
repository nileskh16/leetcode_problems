package com.plural.spring.fundamentals.problems.strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix1(String[] strs) {
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

    public String longestCommonPrefix(String[] args) {
        if (args.length == 1) return args[0];
        String common = args[0];
        for (int i = 1; i < args.length; i++) {
            common = findCommon(common, args[i]);
            if (common.isEmpty()) break;
        }
        return common;
    }

    private String findCommon(String source, String target) {
        int index = 0;
        while (index < source.length() && index < target.length()) {
            if (source.charAt(index) == target.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return source.substring(0, index);
    }
}
