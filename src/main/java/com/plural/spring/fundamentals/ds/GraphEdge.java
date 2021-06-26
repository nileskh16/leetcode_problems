package com.plural.spring.fundamentals.ds;

public class GraphEdge {
    private int fromNode;
    private int toNode;
    private int weight;

    public GraphEdge(int fromNode, int toNode, int weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }

    public int getFromNode() {
        return fromNode;
    }

    public int getToNode() {
        return toNode;
    }

    public int getWeight() {
        return weight;
    }
}
