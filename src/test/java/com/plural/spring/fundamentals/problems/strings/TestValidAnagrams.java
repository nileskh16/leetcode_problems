package com.plural.spring.fundamentals.problems.strings;

import org.junit.Assert;
import org.junit.Test;

public class TestValidAnagrams {

    private final ValidAnagram validAnagram;

    public TestValidAnagrams() {
        validAnagram = new ValidAnagram();
    }

    @Test
    public void testOne() {
        Assert.assertTrue(validAnagram.isAnagram("anagram", "nagaram"));
        Assert.assertFalse(validAnagram.isAnagram("cat", "car"));
        Assert.assertFalse(validAnagram.isAnagram("bb", "ac"));
        Assert.assertTrue(validAnagram.isAnagram("#@#@%$", "$%@#@#"));
    }
}
