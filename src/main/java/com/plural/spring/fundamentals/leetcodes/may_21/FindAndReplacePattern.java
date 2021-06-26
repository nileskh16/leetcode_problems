package com.plural.spring.fundamentals.leetcodes.may_21;

import java.util.*;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] sampleWords, String pattern) {
        List<String> matches = new ArrayList<>();
        Integer distinctChars = distinctLetters(pattern);
        for (String word : sampleWords ) {
            if (word.equals(pattern) || (distinctLetters(word) == distinctChars && checkPattern(word, pattern))) {
                matches.add(word);
            }
        }
        return matches;
    }

    private int distinctLetters(String word) {
        Set<Character> charSet = new HashSet<>();
        for (Character ch : word.toCharArray()) {
            charSet.add(ch);
        }
        return charSet.size();
    }

    private boolean checkPattern(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i=0; i<word.length(); i++) {
            Character letter = word.charAt(i);
            Character alpha = pattern.charAt(i);
            if (!map.containsKey(letter)) {
                map.put(letter, alpha);
            } else if (!map.get(letter).equals(alpha)) return false;
        }
        return true;
    }
}
