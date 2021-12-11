package com.plural.spring.fundamentals.problems.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BalancedString {

    private boolean balanced(int smalls[], int caps[]) {

        for (int i = 0; i < 26; i++) {
            if ((smalls[i] != 0 && caps[i] == 0) || (smalls[i] == 0 && caps[i] != 0))
                return false;
        }
        return true;
    }


    private int smallestBalancedSubstring(String s) {

        int[] small = new int[26];
        int[] caps = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                caps[s.charAt(i) - 'A']++;
            else
                small[s.charAt(i) - 'a']++;
        }

        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            if (small[i] != 0 && caps[i] == 0)
                mp.put((char) (i + 'a'), 1);
            else if (caps[i] != 0 && small[i] == 0)
                mp.put((char) (i + 'A'), 1);
        }

        Arrays.fill(small, 0);
        Arrays.fill(caps, 0);

        int i = 0, st = 0;

        int start = -1, end = -1;

        int minm = Integer.MAX_VALUE;

        while (i < s.length()) {
            if (mp.get(s.charAt(i)) != null) {

                while (st < i) {
                    if (s.charAt(st) >= 65 &&
                            s.charAt(st) <= 90)
                        caps[s.charAt(st) - 'A']--;
                    else
                        small[s.charAt(st) - 'a']--;

                    st++;
                }
                i += 1;
                st = i;
            } else {
                if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                    caps[s.charAt(i) - 'A']++;
                else
                    small[s.charAt(i) - 'a']++;

                while (true) {
                    if (s.charAt(st) >= 65 &&
                            s.charAt(st) <= 90 &&
                            caps[s.charAt(st) - 'A'] > 1) {
                        caps[s.charAt(st) - 'A']--;
                        st++;
                    } else if (s.charAt(st) >= 97 &&
                            s.charAt(st) <= 122 &&
                            small[s.charAt(st) - 'a'] > 1) {
                        small[s.charAt(st) - 'a']--;
                        st++;
                    } else
                        break;
                }

                if (balanced(small, caps) && (minm > (i - st + 1))) {
                    minm = i - st + 1;
                    start = st;
                    end = i;
                }
                i += 1;
            }
        }
        return start == -1 ? -1 : end - start + 1;
    }
}
