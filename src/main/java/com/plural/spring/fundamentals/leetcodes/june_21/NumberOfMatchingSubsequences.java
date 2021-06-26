package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 06/22/2021
Problem Statement: Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
A subsequence of a string is a new string generated from the original string with some characters (can be none)
deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
 */

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (checkSubString(s, word)) count++;
        }
        return count;
    }

    private boolean checkSubString(String parent, String child) {
        if (child.isEmpty() || parent.isEmpty()) return false;
        if (child.length() > parent.length()) return false;
        int index = 0, nextIndex = 0;
        boolean found = false;
        while (index < child.length()) {
            char ch = child.charAt(index);
            while (nextIndex < parent.length()) {
                if (ch == parent.charAt(nextIndex)) {
                    found = true;
                    nextIndex++;
                    break;
                }
                nextIndex++;
                if (nextIndex >= parent.length()) found = false;
            }
            if (found) index++; else return false;
        }
        return true;
    }
}
