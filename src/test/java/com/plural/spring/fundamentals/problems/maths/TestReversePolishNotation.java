package com.plural.spring.fundamentals.problems.maths;

import org.junit.Assert;
import org.junit.Test;

public class TestReversePolishNotation {

    private final ReversePolishNotation polishNotation;

    public TestReversePolishNotation() {
        polishNotation = new ReversePolishNotation();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(9, polishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        Assert.assertEquals(6, polishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        Assert.assertEquals(22, polishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        Assert.assertEquals(0, polishNotation.evalRPN(new String[]{"10", "6", "+", "3", "*", "0", "/"}));
    }
}
