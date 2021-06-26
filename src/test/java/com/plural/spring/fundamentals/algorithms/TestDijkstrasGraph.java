package com.plural.spring.fundamentals.algorithms;

import com.plural.spring.fundamentals.ds.GraphEdge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDijkstrasGraph {

    private DijkstraGraph dijkstraGraph;

    @Before
    public void init() {
        dijkstraGraph = new DijkstraGraph();
    }

    @Test
    public void testOne() {
        dijkstraGraph.setVertices(7);
        dijkstraGraph.addGraphEdge(new GraphEdge(0, 1, 2));
        dijkstraGraph.addGraphEdge(new GraphEdge(0, 2, 6));
        dijkstraGraph.addGraphEdge(new GraphEdge(1, 3, 5));
        dijkstraGraph.addGraphEdge(new GraphEdge(2, 3, 8));
        dijkstraGraph.addGraphEdge(new GraphEdge(3, 5, 15));
        dijkstraGraph.addGraphEdge(new GraphEdge(3, 4, 10));
        dijkstraGraph.addGraphEdge(new GraphEdge(4, 5, 6));
        dijkstraGraph.addGraphEdge(new GraphEdge(4, 6, 2));
        dijkstraGraph.addGraphEdge(new GraphEdge(5, 6, 6));

        Assert.assertEquals(22, dijkstraGraph.getMinDistance(0, 5));
    }
}
