package com.plural.spring.fundamentals.algorithms;

import com.plural.spring.fundamentals.ds.AppGraph;
import com.plural.spring.fundamentals.ds.GraphEdge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAppGraph {

    private AppGraph appGraph;

    @Before
    public void init() {
        appGraph = new AppGraph();
    }

    @Test
    public void testOne() {
        appGraph.initGraph(4, new GraphEdge[]{
                new GraphEdge(0, 1, 3),
                new GraphEdge(0, 2, 5),
                new GraphEdge(0, 3, 2),
                new GraphEdge(1, 2, 1)
        });
        Assert.assertEquals(6, appGraph.kruskalsTraversal());
    }
}
