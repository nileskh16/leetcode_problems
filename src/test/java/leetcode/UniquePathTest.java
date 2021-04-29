package leetcode;

import com.plural.spring.fundamentals.leetcodes.UniquePathTwo;
import org.junit.Assert;
import org.junit.Test;

public class UniquePathTest {

    private final UniquePathTwo uniquePathTwo;

    public UniquePathTest() {
        uniquePathTwo = new UniquePathTwo();
    }

    @Test
    public void testOne() {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int paths = uniquePathTwo.uniquePathsWithObstacles(grid);
        Assert.assertEquals(2, paths);
    }

    @Test
    public void testTwo() {
        int[][] grid = {{0, 1}, {0, 0}};
        int paths = uniquePathTwo.uniquePathsWithObstacles(grid);
        Assert.assertEquals(1, paths);
    }

    @Test
    public void testThree() {
        int[][] grid = {{0, 0}, {0, 0}};
        int paths = uniquePathTwo.uniquePathsWithObstacles(grid);
        Assert.assertEquals(2, paths);
    }

    @Test
    public void testFour() {
        int[][] grid = {};
        Assert.assertThrows(Exception.class, () -> uniquePathTwo.uniquePathsWithObstacles(grid));
    }

    @Test
    public void testFive() {
        int[][] grid = {{}, {}};
        int paths = uniquePathTwo.uniquePathsWithObstacles(grid);
        Assert.assertEquals(0, paths);
    }
}
