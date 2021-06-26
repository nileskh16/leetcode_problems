package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCourseSchedule {

    private CourseSchedule courseSchedule;

    @Before
    public void init() {
        courseSchedule = new CourseSchedule();
    }

    @Test
    public void testOne() {
        int numOfCourses = 2;
        int[][] courses = {{1, 0}};
        Assert.assertTrue(courseSchedule.canFinish(numOfCourses, courses));
    }

    @Test
    public void testTwo() {
        int numOfCourses = 2;
        int[][] courses = {{1, 0}, {0, 1}};
        Assert.assertFalse(courseSchedule.canFinish(numOfCourses, courses));
    }

    @Test
    public void testThree() {
        int numOfCourses = 20;
        int[][] courses = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        Assert.assertFalse(courseSchedule.canFinish(numOfCourses, courses));
    }
}
