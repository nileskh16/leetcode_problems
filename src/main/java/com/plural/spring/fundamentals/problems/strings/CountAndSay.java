package com.plural.spring.fundamentals.problems.strings;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String lastDigit = countAndSay(n - 1);
        return convert(lastDigit);
    }

    private String convert(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        if (s.length() == 1) {
            return String.format("%d%s", 1, s.charAt(0));
        }
        int i = 0;
        while (i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                sb.append(String.format("%d%s", count, s.charAt(i)));
                count = 1;
            }
            i++;
        }
        sb.append(String.format("%d%s", count, s.charAt(i)));
        return sb.toString();
    }
}
