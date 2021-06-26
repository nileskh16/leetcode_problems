package com.plural.spring.fundamentals.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTraversalsTest {

    private TreeTraversals treeTraversals;

    @Before
    public void init() {
        treeTraversals = new TreeTraversals();
    }

    @Test
    public void testOne() {
        treeTraversals.addNode(34, 12, 3, 89, 77, 102, 30, 21, 340, 1);
        Assert.assertArrayEquals(new Integer[]{1, 3, 12, 21, 30, 34, 77, 89, 102, 340}, treeTraversals.treeTraversal("IN_ORDER").toArray());
        Assert.assertArrayEquals(new Integer[]{34, 12, 3, 1, 30, 21, 89, 77, 102, 340}, treeTraversals.treeTraversal("PRE_ORDER").toArray());
        Assert.assertArrayEquals(new Integer[]{1, 3, 30, 21, 12, 89, 77, 102, 340, 34}, treeTraversals.treeTraversal("POST_ORDER").toArray());
        Assert.assertArrayEquals(new Integer[]{34, 12, 89, 3, 30, 77, 102, 1, 21, 340}, treeTraversals.treeTraversal("BFS").toArray());
        Assert.assertArrayEquals(new Integer[]{34, 12, 3, 1, 30, 21, 89, 77, 102, 340}, treeTraversals.treeTraversal("DFS").toArray());
    }
}