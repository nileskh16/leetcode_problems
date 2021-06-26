package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestLongestCommonPrefix {

    private final LongestCommonPrefix prefix;

    public TestLongestCommonPrefix() {
        prefix = new LongestCommonPrefix();
    }

    @Test
    public void testOne() {
        String[] strs = {"flower", "flow", "flight"};
        Assert.assertEquals("fl", prefix.longestCommonPrefix(strs));
    }

    @Test
    public void testTwo() {
        String[] strs = {"dog", "racecar", "car"};
        Assert.assertEquals("", prefix.longestCommonPrefix(strs));
    }

    @Test
    public void testThree() {
        String[] strs = {"car"};
        Assert.assertEquals("car", prefix.longestCommonPrefix(strs));
    }

    @Test
    public void testFour() {
        String[] strs = {"power", "pow", "po", ""};
        Assert.assertEquals("", prefix.longestCommonPrefix(strs));
    }

    @Test
    public void testFive() {
        String[] strs = {"flower", "flowing", "flow"};
        Assert.assertEquals("flow", prefix.longestCommonPrefix(strs));
    }

    @Test
    public void testSix() {
        String[] strs = {"flower", "flower", "flower"};
        Assert.assertEquals("flower", prefix.longestCommonPrefix(strs));
    }
}
