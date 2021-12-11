package com.plural.spring.fundamentals.problems.backtracking;

import org.junit.Assert;
import org.junit.Test;

public class TestLetterCombination {

    private final LetterCombination letterCombination;

    public TestLetterCombination() {
        letterCombination = new LetterCombination();
    }

    @Test
    public void testOne() {
        Assert.assertArrayEquals(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}, letterCombination.letterCombinations("23").toArray());
        Assert.assertArrayEquals(new String[]{"p", "q", "r", "s"}, letterCombination.letterCombinations("7").toArray());
        Assert.assertArrayEquals(new String[]{}, letterCombination.letterCombinations("").toArray());
    }
}
