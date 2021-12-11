package com.plural.spring.fundamentals.contest.amazon;

import com.plural.spring.fundamentals.contests.amazon.AmaWordBreak;
import org.junit.Assert;
import org.junit.Test;

public class TestAmaWordBreak {

    private final AmaWordBreak wordBreak;

    public TestAmaWordBreak() {
        wordBreak = new AmaWordBreak();
    }

    @Test
    public void testOne() {
        Assert.assertTrue(wordBreak.isValidWord(new String[]{"apple", "is", "bad"}, "appleappleisbad"));
        Assert.assertTrue(wordBreak.isValidWord(new String[]{"leet", "code"}, "leetcode"));
        Assert.assertFalse(wordBreak.isValidWord(new String[]{"cats", "dog", "sand", "and", "cat"}, "catsandog"));
    }
}
