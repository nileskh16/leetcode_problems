package com.plural.spring.fundamentals.problems.maths;

import org.junit.Assert;
import org.junit.Test;

public class TestTaskScheduler {

    private final TaskScheduler taskScheduler;

    public TestTaskScheduler() {
        taskScheduler = new TaskScheduler();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(16, taskScheduler.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
        Assert.assertEquals(8, taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        Assert.assertEquals(6, taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
        Assert.assertEquals(8, taskScheduler.leastInterval(new char[]{'A','B','B','A','A','B'}, 2));
    }
}
