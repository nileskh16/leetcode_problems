package com.plural.spring.fundamentals.contest.apple;

import com.plural.spring.fundamentals.contests.apple.AppNumberOfIslands;
import org.junit.Assert;
import org.junit.Test;

public class TestAppNumberOfIslands {

    private final AppNumberOfIslands numberOfIslands;

    public TestAppNumberOfIslands() {
        numberOfIslands = new AppNumberOfIslands();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(1, numberOfIslands.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(3, numberOfIslands.numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
