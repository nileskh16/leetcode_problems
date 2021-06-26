package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.ReversePolish;
import org.junit.Assert;
import org.junit.Test;

public class TestReversePolish {
    private final ReversePolish reversePolish;

    public TestReversePolish() {
        reversePolish = new ReversePolish();
    }

    @Test
    public void testOne() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        Assert.assertEquals(9, reversePolish.evalRPN(tokens));
    }

    @Test
    public void testTwo() {
        String[] params = {"4", "13", "5", "/", "+"};
        Assert.assertEquals(6, reversePolish.evalRPN(params));
    }

    @Test
    public void testThree() {
        String[] params = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Assert.assertEquals(22, reversePolish.evalRPN(params));
    }

    @Test
    public void testFour() {
        String[] params = {"3", "4", "5", "*", "-"};
        Assert.assertEquals(-17, reversePolish.evalRPN(params));
    }
}
