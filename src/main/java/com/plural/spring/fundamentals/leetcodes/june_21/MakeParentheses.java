package com.plural.spring.fundamentals.leetcodes.june_21;

import java.util.ArrayList;
import java.util.List;

public class MakeParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        makePair(n, n, "", result);
        return result;
    }

    private void makePair(int left, int right, String str, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(str);
        }
        if (left > 0) {
            makePair(left - 1, right, str + "(", result);
        }
        if (right > left) {
            makePair(left, right - 1, str + ")", result);
        }
    }
}