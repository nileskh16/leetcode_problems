package com.plural.spring.fundamentals.contest.microsoft;

import com.plural.spring.fundamentals.contests.microsoft.MinTrainPlatforms;
import org.junit.Assert;
import org.junit.Test;

public class TestMinTrainPlatforms {

    private final MinTrainPlatforms minTrainPlatforms;

    public TestMinTrainPlatforms() {
        minTrainPlatforms = new MinTrainPlatforms();
    }

    @Test
    public void testOne() {
        int[] arr = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        Assert.assertEquals(3, minTrainPlatforms.numOfPlatforms(arr, dep));
    }

    @Test
    public void testTwo() {
        int[] arr = new int[]{900, 940, 1035, 1130, 1500, 1800};
        int[] dep = new int[]{2100, 1030, 1120, 1230, 1600, 2000};
        Assert.assertEquals(2, minTrainPlatforms.numOfPlatforms(arr, dep));
    }

    @Test
    public void testThree() {
        int[] arr = new int[]{900, 940, 1035, 1130, 1500, 1800};
        int[] dep = new int[]{930, 1030, 1120, 1230, 1600, 2000};
        Assert.assertEquals(1, minTrainPlatforms.numOfPlatforms(arr, dep));
    }

    @Test
    public void testFour() {
        int[] arr = new int[]{900, 930, 1000, 1030, 1100, 1130};
        int[] dep = new int[]{2100, 2030, 2000, 1930, 1900, 1830};
        Assert.assertEquals(6, minTrainPlatforms.numOfPlatforms(arr, dep));
    }

    @Test
    public void testFive() {
        int[] arr = new int[]{900, 930, 1000, 1030, 1100, 1130};
        int[] dep = new int[]{2100, 2030, 2000, 1930, 1900, 1830};
        Assert.assertEquals(6, minTrainPlatforms.numOfPlatforms(arr, dep));
    }
}
