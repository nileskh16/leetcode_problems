package leetcode;

import com.plural.spring.fundamentals.leetcodes.FurthestBuilding;
import org.junit.Assert;
import org.junit.Test;

public class FurthestBuildingTest {

    private final FurthestBuilding furthestBuilding;

    public FurthestBuildingTest() {
        furthestBuilding = new FurthestBuilding();
    }

    @Test
    public void testResultOne() {
        int array[] = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;

        Assert.assertEquals(4, furthestBuilding.furthestIndex(array, bricks, ladders));
    }

    @Test
    public void testResultTwo() {
        int array[] = {4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladders = 2;

        Assert.assertEquals(7, furthestBuilding.furthestIndex(array, bricks, ladders));
    }

    @Test
    public void testResultThree() {
        int array[] = {14,3,19,3};
        int bricks = 17;
        int ladders = 0;

        Assert.assertEquals(3, furthestBuilding.furthestIndex(array, bricks, ladders));
    }

    @Test
    public void testResultFour() {
        int array[] = {7,5,13};
        int bricks = 0;
        int ladders = 0;

        Assert.assertEquals(1, furthestBuilding.furthestIndex(array, bricks, ladders));
    }
}
