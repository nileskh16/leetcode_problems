package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.OutOfBoundaryPaths;
import org.junit.Assert;
import org.junit.Test;

public class TestOutOfBoundaryPaths {

    private final OutOfBoundaryPaths boundaryPaths;

    public TestOutOfBoundaryPaths() {
        boundaryPaths = new OutOfBoundaryPaths();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(6, boundaryPaths.findPaths(2, 2, 2, 0, 0));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(12, boundaryPaths.findPaths(1, 3, 3, 0, 1));
    }
}
