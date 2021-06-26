package com.plural.spring.fundamentals.ds;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class AppGraph {

    private int[][] adj_matrix;
    private GraphEdge[] edges;
    private int vertices;

    public void initGraph(int v, GraphEdge[] edges) {
        adj_matrix = new int[v][v];
        this.edges = edges;
        vertices = v;
        initMatrix();
    }

    private void initMatrix() {
        if (edges != null && edges.length > 0) {
            for (GraphEdge edge : edges) {
                adj_matrix[edge.getFromNode()][edge.getToNode()] = edge.getWeight();
                adj_matrix[edge.getToNode()][edge.getFromNode()] = edge.getWeight();
            }
        }
    }

    public int weightOfMinSpanTree() {
        int weight = 0;
        int count = 1;
        boolean[] visited = new boolean[vertices];
        visited[0] = true;

        while (count != vertices) {
            int min = Integer.MAX_VALUE;
            int nextNode = -1;
            for (int i = 0; i < vertices; i++) {
                if (visited[i]) {
                    for (int j = 0; j < vertices; j++) {
                        if (!visited[j]) {
                            int tempWeight = adj_matrix[i][j];
                            if (tempWeight != 0 && tempWeight < min) {
                                min = tempWeight;
                                nextNode = j;
                            }
                        }
                    }
                }
            }
            visited[nextNode] = true;
            weight += min;
            count++;
        }
        return weight;
    }

    public int kruskalsTraversal() {
        int pathCost = 0;
        int index = 0;
        int[] parent = new int[vertices];

        for (int i=0; i<vertices; i++) {
            parent[i] = i;
        }

        Queue<GraphEdge> queue = new PriorityQueue<>(Comparator.comparingInt((GraphEdge o) -> o.getWeight()));
        boolean[] visited = new boolean[vertices];
        for (GraphEdge edge : edges) {
            queue.add(edge);
        }
        while (index < vertices - 1) {
            if (queue.isEmpty()) return -1;
            GraphEdge edge = queue.poll();
            int x = find(parent, edge.getFromNode());
            int y = find(parent, edge.getToNode());
            if (x != y) {
                pathCost += edge.getWeight();
                index++;
                union(parent, x, y);
            }
        }
        return pathCost;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            return find(parent, parent[vertex]);
        }
        return vertex;
    }

    private void union(int[] parent, int x, int y) {
        int x_vertex = find(parent, x);
        int y_vertex = find(parent, y);
        parent[y_vertex] = x_vertex;
    }

    private boolean doesFormACycle(GraphEdge edge, boolean[] visited) {
        return visited[edge.getToNode()];
    }
}
