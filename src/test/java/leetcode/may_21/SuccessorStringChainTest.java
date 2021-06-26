package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.SuccessorString;
import org.junit.Assert;
import org.junit.Test;

public class SuccessorStringChainTest {

    private final SuccessorString successorString;

    public SuccessorStringChainTest() {
        successorString = new SuccessorString();
    }

    @Test
    public void testOne() {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        Assert.assertEquals(4, successorString.getMaximumNumberOfStrings(words));
    }

    @Test
    public void testTwo() {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        Assert.assertEquals(5, successorString.getMaximumNumberOfStrings(words));
    }
}
