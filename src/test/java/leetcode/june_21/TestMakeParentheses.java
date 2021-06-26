package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.MakeParentheses;
import org.junit.Assert;
import org.junit.Test;

public class TestMakeParentheses {

    private final MakeParentheses parentheses;

    public TestMakeParentheses() {
        parentheses = new MakeParentheses();
    }

    @Test
    public void testOne() {
        Assert.assertArrayEquals(new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"},
                parentheses.generateParenthesis(3).toArray());
    }

    @Test
    public void testTwo() {
        Assert.assertArrayEquals(new String[]{"()"}, parentheses.generateParenthesis(1).toArray());
    }

    @Test
    public void testThree() {
        Assert.assertArrayEquals(new String[]{"(())", "()()"}, parentheses.generateParenthesis(2).toArray());
    }
}
