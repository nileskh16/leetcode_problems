package com.plural.spring.fundamentals.algorithms;

import java.util.*;

public class KruskalsAlgo {

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>(7);
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(2, 3, 3));
        edges.add(new Edge(2, 4, 2));
        edges.add(new Edge(3, 5, 3));
        edges.add(new Edge(4, 5, 3));
        System.out.println("MST of the graph is: " + findMST(edges, 6));
    }

    public static int findMST(List<Edge> edges, int v) {
        int weight = 0;
        boolean[] visited = new boolean[v];
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt((Edge a) -> a.weight));
        queue.addAll(edges);

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (visited[edge.from] && visited[edge.to]) continue;
            visited[edge.from] = true;
            visited[edge.to] = true;
            System.out.printf("Edge from %d -> %d is added with weight %d%n", edge.from, edge.to, edge.weight);
            weight += edge.weight;
        }
        return weight;
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
