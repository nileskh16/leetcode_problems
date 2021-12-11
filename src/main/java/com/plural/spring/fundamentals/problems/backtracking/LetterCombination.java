package com.plural.spring.fundamentals.problems.backtracking;

import java.util.*;

public class LetterCombination {

    private final Map<Character, String> charMap;

    LetterCombination() {
        charMap = new HashMap<>();
        charMap.put('2', "abc");
        charMap.put('3', "def");
        charMap.put('4', "ghi");
        charMap.put('5', "jkl");
        charMap.put('6', "mno");
        charMap.put('7', "pqrs");
        charMap.put('8', "tuv");
        charMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (Objects.isNull(digits) || digits.isEmpty()) return ans;
        for (int i = digits.length() - 1; i >= 0; i--) {
            ans = combineText(charMap.get(digits.charAt(i)), ans);
        }
        return ans;
    }

    private List<String> combineText(String target, List<String> ans) {
        List<String> combination = new ArrayList<>();
        for (char ch : target.toCharArray()) {
            if (!ans.isEmpty()) {
                for (String s : ans) {
                    combination.add(ch + s);
                }
            } else {
                combination.add(String.valueOf(ch));
            }
        }
        return combination;
    }
}
