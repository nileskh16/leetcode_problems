package com.plural.spring.fundamentals.problems.strings;

import org.junit.Assert;
import org.junit.Test;

public class TestLongestSubstringWithoutRepetitions {

    private final LongestSubstringWithoutRepetitions longestSubstring;

    public TestLongestSubstringWithoutRepetitions() {
        longestSubstring = new LongestSubstringWithoutRepetitions();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(3, longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(6, longestSubstring.lengthOfLongestSubstring("cadcbefab"));
        Assert.assertEquals(1, longestSubstring.lengthOfLongestSubstring("bbbbbbb"));
        Assert.assertEquals(0, longestSubstring.lengthOfLongestSubstring(""));
        Assert.assertEquals(26, longestSubstring.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyz"));
        Assert.assertEquals(2, longestSubstring.lengthOfLongestSubstring("cdd"));
    }
}
