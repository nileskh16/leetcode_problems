package com.plural.spring.fundamentals.problems.strings;

public class StrStrImplementation {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        char ch = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == ch && doStringsMatch(haystack, needle, i)) return i;
        }
        return -1;
    }

    public int strStr1(String needle, String haystack) {
        if (needle.isEmpty() || haystack.isEmpty()) return 0;
        if (haystack.length() > needle.length()) return -1;
        int index = -1, left = 0, right = 0;
        while (left < needle.length()) {
            if (needle.charAt(left) == haystack.charAt(right)) {
                if (index == -1) index = left;
                right++;
                if (right >= haystack.length()) break;
            } else {
                if (index != -1) left--;
                index = -1;
                right = 0;
            }
            left++;
        }
        return index;
    }

    private boolean doStringsMatch(String parent, String child, int parentIndex) {
        for (int i = 0; i < child.length(); i++) {
            if (parentIndex >= parent.length()) return false;
            if (child.charAt(i) != parent.charAt(parentIndex)) return false;
            parentIndex++;
        }
        return true;
    }
}