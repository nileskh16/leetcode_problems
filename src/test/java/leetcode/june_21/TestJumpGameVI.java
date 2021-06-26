package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.JumpGameVI;
import org.junit.Assert;
import org.junit.Test;

public class TestJumpGameVI {

    private final JumpGameVI jumpGame;

    public TestJumpGameVI() {
        jumpGame = new JumpGameVI();
    }

    @Test
    public void testOne() {
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;
        Assert.assertEquals(7, jumpGame.maxResult(nums, k));
    }

    @Test
    public void testTwo() {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;
        Assert.assertEquals(17, jumpGame.maxResult(nums, k));
    }

    @Test
    public void testThree() {
        int[] nums = {1, -5, -20, 4, -1, 3, -6, -3};
        int k = 2;
        Assert.assertEquals(0, jumpGame.maxResult(nums, k));
    }
}
