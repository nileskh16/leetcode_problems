package com.plural.spring.fundamentals.leetcodes.july_21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountVowelsPermutation {

    public int countVowelPermutation(int n) {
        Map<Character, List<Character>> store = getStore();
        int count = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char ch : vowels) {
            count += getCount(store, n, ch);
        }
        return count;
    }

    private Map<Character, List<Character>> getStore() {
        Map<Character, List<Character>> store = new HashMap<>();
        store.put('a', Arrays.asList('e'));
        store.put('e', Arrays.asList('a', 'i'));
        store.put('i', Arrays.asList('a', 'e', 'o', 'u'));
        store.put('o', Arrays.asList('i', 'u'));
        store.put('u', Arrays.asList('a'));
        return store;
    }

    private int getCount(Map<Character, List<Character>> store, int length, Character next) {
        if (length <= 1) return 1;
        if (length == 2) return store.get(next).size();
        int count = 1;
        for (Character ch : store.get(next)) {
            count += (int) ((long)1000000007 % getCount(store, length - 1, ch));
        }
        return count;
    }
}
