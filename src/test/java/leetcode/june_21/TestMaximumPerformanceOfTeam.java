package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.MaximumPerformanceOfTeam;
import org.junit.Assert;
import org.junit.Test;

public class TestMaximumPerformanceOfTeam {

    private final MaximumPerformanceOfTeam performanceOfTeam;

    public TestMaximumPerformanceOfTeam() {
        performanceOfTeam = new MaximumPerformanceOfTeam();
    }

    @Test
    public void testOne() {
        int n = 6;
        int k = 2;
        int[] speeds = {2, 10, 3, 1, 5, 8};
        int[] efficiencies = {5, 4, 3, 9, 7, 2};
        Assert.assertEquals(60, performanceOfTeam.maxPerformance(n, speeds, efficiencies, k));
    }

    @Test
    public void testTwo() {
        int n = 6;
        int k = 3;
        int[] speeds = {2, 10, 3, 1, 5, 8};
        int[] efficiencies = {5, 4, 3, 9, 7, 2};
        Assert.assertEquals(68, performanceOfTeam.maxPerformance(n, speeds, efficiencies, k));
    }

    @Test
    public void testThree() {
        int n = 6;
        int k = 4;
        int[] speeds = {2, 10, 3, 1, 5, 8};
        int[] efficiencies = {5, 4, 3, 9, 7, 2};
        Assert.assertEquals(72, performanceOfTeam.maxPerformance(n, speeds, efficiencies, k));
    }

    @Test
    public void testFour() {
        int n = 6;
        int k = 3;
        int[] speeds = {2, 10, 3, 1, 5, 8};
        int[] efficiencies = {5, 4, 3, 9, 7, 6};
        Assert.assertEquals(92, performanceOfTeam.maxPerformance(n, speeds, efficiencies, k));
    }
}
