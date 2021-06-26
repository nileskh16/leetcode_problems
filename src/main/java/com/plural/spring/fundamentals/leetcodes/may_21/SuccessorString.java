package com.plural.spring.fundamentals.leetcodes.may_21;

import java.util.Arrays;
import java.util.Comparator;

public class SuccessorString {

    public int getMaximumNumberOfStrings(String[] words) {
        if (words.length <= 0) return 0;
        if (words.length == 1) return 1;
        sortByStrLength(words);
        int maxCount = 0;
        for (int i = 0; i < words.length; i++) {
            int count = 1;
            int temp = i;
            for (int j = i + 1; j < words.length; j++) {
                String first = words[i];
                String second = words[j];
                if ((first.length() - second.length()) != 1) continue;
                if (isSuccessor(words[i], words[j])) {
                    count++;
                    i=j;
                }
            }
            maxCount = Math.max(maxCount, count);
            if (maxCount == words.length) break;
            i=temp;
        }
        return maxCount;
    }

    private void sortByStrLength(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) return 1;
                else if (o1.length() > o2.length()) return -1;
                else return 0;
            }
        });
    }

    private boolean isSuccessor(String first, String second) {
        String diff = difference(second, first);
        return diff.length() == 1;
    }

    private String difference(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }
        if (str2 == null) {
            return str1;
        }
        int at = indexOfDifference(str1, str2);
        if (at == -1) {
            return "";
        }
        return str2.substring(at, at + 1);
    }

    private int indexOfDifference(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
            return -1;
        }
        if (cs1 == null || cs2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < cs1.length() && i < cs2.length(); ++i) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
                break;
            }
        }
        if (i < cs2.length() || i < cs1.length()) {
            return i;
        }
        return -1;
    }
}