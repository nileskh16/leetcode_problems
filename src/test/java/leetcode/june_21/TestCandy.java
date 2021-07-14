package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.Candy;
import org.junit.Assert;
import org.junit.Test;

public class TestCandy {

    private final Candy candy;

    public TestCandy() {
        candy = new Candy();
    }

    @Test
    public void testOne() {
        int[] ratings = {1, 0, 2};
        Assert.assertEquals(5, candy.candy(ratings));
    }

    @Test
    public void testTwo() {
        int[] ratings = {1, 2, 2};
        Assert.assertEquals(4, candy.candy(ratings));
    }

    @Test
    public void testThree() {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        Assert.assertEquals(13, candy.candy(ratings));
    }
}
