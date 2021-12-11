package com.plural.spring.fundamentals.contest.amazon;

import com.plural.spring.fundamentals.contests.amazon.AmaLongestPalindromicSubString;
import org.junit.Assert;
import org.junit.Test;

public class TestAmaLongestPalindromeSubString {

    private final AmaLongestPalindromicSubString amaLongestPalindromicSubString;

    public TestAmaLongestPalindromeSubString() {
        amaLongestPalindromicSubString = new AmaLongestPalindromicSubString();
    }

    @Test
    public void testOne() {
        Assert.assertEquals("bab", amaLongestPalindromicSubString.longestPalindrome("babad"));
        Assert.assertEquals("bb", amaLongestPalindromicSubString.longestPalindrome("cbbd"));
        Assert.assertEquals("a", amaLongestPalindromicSubString.longestPalindrome("a"));
        Assert.assertEquals("a", amaLongestPalindromicSubString.longestPalindrome("ac"));
        Assert.assertEquals("a", amaLongestPalindromicSubString.longestPalindrome("abcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }
}
