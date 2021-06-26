package com.plural.spring.fundamentals.algorithms;

import com.plural.spring.fundamentals.ds.GraphEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraGraph {

    private int vertices;
    private Map<Integer, List<GraphEdge>> adjacentNodes;

    public DijkstraGraph() {
        adjacentNodes = new HashMap<>();
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public void addGraphEdge(GraphEdge edge) {
        int fromNode = edge.getFromNode();
        if (!adjacentNodes.containsKey(fromNode)) {
            adjacentNodes.put(fromNode, new ArrayList<>());
        }
        adjacentNodes.get(fromNode).add(edge);
    }

    public int getMinDistance(int source, int destination) {
        int distance = 0;
        int[] matrix = new int[vertices];
        boolean[] visited = new boolean[vertices];
        int count = 1;
        initDistanceMatrix(matrix, source);
        visited[source] = true;

        while (count != vertices) {
            int minDistance = Integer.MAX_VALUE;
            int nextVertex = -1;
            for (int i = 0; i < vertices; i++) {
                if (visited[i] && adjacentNodes.containsKey(i)) {
                    for (GraphEdge edge : adjacentNodes.get(i)) {
                        int toNode = edge.getToNode();
                        if (!visited[toNode]) {
                            int weight = edge.getWeight();
                            int fromNode = edge.getFromNode();
                            int tempDistance = weight + matrix[fromNode];
                            if (minDistance > tempDistance) {
                                minDistance = tempDistance;
                                nextVertex = toNode;
                            }
                        }
                    }
                }
            }
            matrix[nextVertex] = minDistance;
            visited[nextVertex] = true;
            count++;
        }

        return matrix[destination];
    }

    private void initDistanceMatrix(int[] matrix, int source) {
        for (int i = 0; i < vertices; i++) {
            if (i == source) {
                matrix[i] = 0;
            } else {
                matrix[i] = Integer.MAX_VALUE;
            }
        }
    }
}
