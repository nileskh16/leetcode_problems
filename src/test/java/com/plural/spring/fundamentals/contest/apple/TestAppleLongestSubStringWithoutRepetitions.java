package com.plural.spring.fundamentals.contest.apple;

import com.plural.spring.fundamentals.contests.apple.AppleLongestSubstringWithoutRepetitions;
import org.junit.Assert;
import org.junit.Test;

public class TestAppleLongestSubStringWithoutRepetitions {

    private final AppleLongestSubstringWithoutRepetitions longestSubstringWithoutRepetitions;

    public TestAppleLongestSubStringWithoutRepetitions() {
        longestSubstringWithoutRepetitions = new AppleLongestSubstringWithoutRepetitions();
    }

    @Test
    public void test() {
        Assert.assertEquals(5, longestSubstringWithoutRepetitions.lengthOfLongestSubstring("abccdefggggh"));
        Assert.assertEquals(1, longestSubstringWithoutRepetitions.lengthOfLongestSubstring("ggggggggg"));
    }
}
