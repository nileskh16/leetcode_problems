package com.plural.spring.fundamentals.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backTrack(List<String> ans, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            ans.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append('(');
            backTrack(ans, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backTrack(ans, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
