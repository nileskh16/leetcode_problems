package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.MinimumRefuelingStops;
import org.junit.Assert;
import org.junit.Test;

public class TestMinimumRefuellingStops {

    private final MinimumRefuelingStops stops;

    public TestMinimumRefuellingStops() {
        stops = new MinimumRefuelingStops();
    }

    @Test
    public void testOne() {
        int[][] stations = {};
        int target = 1;
        int startFuel = 1;
        Assert.assertEquals(0, stops.minRefuelStops(target, startFuel, stations));
    }

    @Test
    public void testTwo() {
        int[][] stations = {{10, 1000}};
        int target = 100;
        int startFuel = 1;
        Assert.assertEquals(-1, stops.minRefuelStops(target, startFuel, stations));
    }

    @Test
    public void testThree() {
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int target = 100;
        int startFuel = 10;
        Assert.assertEquals(2, stops.minRefuelStops(target, startFuel, stations));
    }

    @Test
    public void testFour() {
        int[][] stations = {{25, 25}, {50, 25}, {75, 25}};
        int target = 100;
        int startFuel = 25;
        Assert.assertEquals(3, stops.minRefuelStops(target, startFuel, stations));
    }
}
