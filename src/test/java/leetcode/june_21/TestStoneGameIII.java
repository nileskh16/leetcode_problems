package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.StoneGameIII;
import org.junit.Assert;
import org.junit.Test;

public class TestStoneGameIII {

    private final StoneGameIII stoneGame;

    public TestStoneGameIII() {
        stoneGame = new StoneGameIII();
    }

    @Test
    public void testOne() {
        int[] stones = {5, 3, 1, 4, 2};
        Assert.assertEquals(6, stoneGame.stoneGameVII(stones));
    }
}
