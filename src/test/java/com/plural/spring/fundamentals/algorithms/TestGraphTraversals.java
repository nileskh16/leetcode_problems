package com.plural.spring.fundamentals.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class TestGraphTraversals {
    private GraphTraversals graphTraversals;

    @Test
    public void testOne() {
        graphTraversals = new GraphTraversals(7, false);
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {1, 3}, {3, 4}, {3, 5}, {4, 5}, {4, 6}, {5, 6}};
        graphTraversals.constructGraph(edges);
        System.out.println(graphTraversals.dfs());
        System.out.println(graphTraversals.bfs());
        Assert.assertTrue(graphTraversals.checkIfCycleExists());
    }
}
