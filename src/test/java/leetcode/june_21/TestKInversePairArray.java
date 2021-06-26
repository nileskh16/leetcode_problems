package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.KInversePairsArray;
import org.junit.Assert;
import org.junit.Test;

public class TestKInversePairArray {

    private final KInversePairsArray inversePairsArray;

    public TestKInversePairArray() {
        inversePairsArray = new KInversePairsArray();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(1, inversePairsArray.kInversePairs(3, 0));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(2, inversePairsArray.kInversePairs(3, 1));
    }
}
