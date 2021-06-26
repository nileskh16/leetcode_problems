package com.plural.spring.fundamentals.leetcodes.may_21;

public class DeleteOnStrings {

    public static void main(String[] args) {
        DeleteOnStrings deleteOnStrings = new DeleteOnStrings();
        System.out.println(deleteOnStrings.minDistance("sea", "eat"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(); int n = word2.length();
        if (m < n) {
            String tempStr = word1;
            word1 = word2;
            word2 = tempStr;
            m = word1.length();
            n = word2.length();
        }
        char[] wordOneArray = word1.toCharArray();
        char[] wordTwoArray = word2.toCharArray();
        int[] dpCurr = new int[n+1];
        int[] dpLast = new int[n+1];

        for (char c : wordOneArray) {
            for (int i=0; i<n; i++) {
                dpCurr[i+1] = c == wordTwoArray[i] ? dpLast[i] + 1 : Math.max(dpCurr[i], dpLast[i+1]);
            }
            int[] tmpAr = dpLast;
            dpLast = dpCurr;
            dpCurr = tmpAr;
        }
        return m + n - 2*dpLast[n];
    }

    private String findCommonWord(String word1, String word2) {
        StringBuilder sb = new StringBuilder("");
        String maxString = "";
        int sourceIndex = 0;
        int targetIndex = 0;
        while (sourceIndex < word1.length()) {
            if (word1.charAt(sourceIndex) == word2.charAt(targetIndex)) {
                maxString = sb.toString();
                sb.setLength(0);
                while (word1.charAt(sourceIndex) == word2.charAt(targetIndex)) {
                    sb.append(word1.charAt(sourceIndex));
                    sourceIndex++;
                    targetIndex++;
                    if (sourceIndex >= word1.length() || targetIndex >= word2.length()) return sb.toString();
                }
                targetIndex = 0;
            } else {
                sourceIndex++;
            }
        }
        return maxString.length() > sb.length() ? maxString : sb.toString();
    }

    private boolean contains(String word1, String word2) {
        int sourceIndex = 0;
        int targetIndex = 0;
        while (sourceIndex < word1.length()) {
            if (word1.charAt(sourceIndex) == word2.charAt(targetIndex)) {
                while (word1.charAt(sourceIndex) == word2.charAt(targetIndex)) {
                    sourceIndex++;
                    targetIndex++;
                    if (targetIndex == word2.length()) return true;
                    if (sourceIndex >= word1.length()) return false;
                }
                targetIndex = 0;
            } else {
                sourceIndex++;
            }
        }
        return false;
    }
}
