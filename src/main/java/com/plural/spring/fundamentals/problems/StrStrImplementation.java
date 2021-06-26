package com.plural.spring.fundamentals.problems;

public class StrStrImplementation {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        char ch = needle.charAt(0);
        for (int i = 0; i<haystack.length(); i++) {
            if (haystack.charAt(i) == ch && doStringsMatch(haystack, needle, i)) return i;
        }
        return -1;
    }

    private boolean doStringsMatch(String parent, String child, int parentIndex) {
        for (int i=0; i<child.length(); i++) {
            if (parentIndex >= parent.length()) return false;
            if (child.charAt(i) != parent.charAt(parentIndex)) return false;
            parentIndex++;
        }
        return true;
    }
}
