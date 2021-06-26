package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestValidParentheses {

    private final ValidParentheses parentheses;

    public TestValidParentheses() {
        parentheses = new ValidParentheses();
    }

    @Test
    public void testOne() {
        Assert.assertTrue(parentheses.isValid("()"));
        Assert.assertTrue(parentheses.isValid("()[]{}"));
        Assert.assertFalse(parentheses.isValid("(]"));
        Assert.assertFalse(parentheses.isValid("([)]"));
        Assert.assertTrue(parentheses.isValid("([])"));
    }
}
