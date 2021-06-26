package com.plural.spring.fundamentals.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> str = new Stack<>();
        List<Character> open = Arrays.asList('(', '[', '{');
        for (char ch : s.toCharArray()) {
            if (open.contains(ch)) str.push(ch);
            else {
                if (str.empty()) return false;
                char top = str.peek();
                switch (ch) {
                    case ')':
                        if (top != '(') return false;
                        break;
                    case '}':
                        if (top != '{') return false;
                        break;
                    case ']':
                        if (top != '[') return false;
                        break;
                    default:
                        break;
                }
                str.pop();
            }
        }
        return str.isEmpty();
    }
}
