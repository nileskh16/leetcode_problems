package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 06/28/2021
Problem Statement:
You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!deque.isEmpty() && deque.peek() == ch) deque.pop();
            else deque.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeLast());
        }
        return sb.toString();
    }
}
