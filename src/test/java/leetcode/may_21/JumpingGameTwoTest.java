package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.april_21.JumpingGameTwo;
import org.junit.Assert;
import org.junit.Test;

public class JumpingGameTwoTest {

    private final JumpingGameTwo gameTwo;

    public JumpingGameTwoTest() {
        gameTwo = new JumpingGameTwo();
    }

    @Test
    public void testOne() {
        int[] nums = {2, 3, 1, 1, 4};
        Assert.assertEquals(2, gameTwo.minJumps(nums));
    }

    @Test
    public void testTwo() {
        int[] nums = {2, 3, 0, 1, 4};
        Assert.assertEquals(2, gameTwo.minJumps(nums));
    }

    @Test
    public void testThree() {
        int[] nums = {5, 5, 1, 1, 1, 3, 1, 1, 4};
        Assert.assertEquals(2, gameTwo.minJumps(nums));
    }

    @Test
    public void testFour() {
        int[] nums = {5, 3, 1, 1, 1, 1, 4};
        Assert.assertEquals(2, gameTwo.minJumps(nums));
    }
}
