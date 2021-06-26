package com.plural.spring.fundamentals.algorithms;

import java.util.*;

public class GraphTraversals {

    private int vertices;
    private Map<Integer, List<Integer>> adjList;
    private boolean isDirected;

    public GraphTraversals(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        this.adjList = new HashMap<>();
    }

    public void constructGraph(int[][] edges) {
        int numOfEdges = edges.length;
        for (int i = 0; i < numOfEdges; i++) {
            int[] edge = edges[i];
            int fromNode = edge[0];
            int toNode = edge[1];
            addEdge(fromNode, toNode);
        }
    }

    public List<Integer> dfs() {
        List<Integer> nodes = new ArrayList<>();
        dfsTraversal(nodes, 0);
        return nodes;
    }

    public List<Integer> bfs() {
        List<Integer> nodes = new ArrayList<>();
        bfsTraversal(nodes, 0);
        return nodes;
    }

    public boolean checkIfCycleExists() {
        boolean[] visited = new boolean[vertices];
        if (isDirected) {
            boolean[] onStack = new boolean[vertices];
            return isDirectedCyclic(visited, onStack, 0);
        } else {
            return isUndirectedCyclic(visited, 0, 0);
        }
    }

    private void addEdge(int fromNode, int toNode) {
        if (!adjList.containsKey(fromNode)) {
            adjList.put(fromNode, new ArrayList<>());
        }
        adjList.get(fromNode).add(toNode);
        if (!isDirected) {
            if (!adjList.containsKey(toNode)) {
                adjList.put(toNode, new ArrayList<>());
            }
            adjList.get(toNode).add(fromNode);
        }
    }

    private void dfsTraversal(List<Integer> nodes, int node) {
        nodes.add(node);
        if (adjList.containsKey(node)) {
            for (int child : adjList.get(node)) {
                if (nodes.contains(child)) continue;
                dfsTraversal(nodes, child);
            }
        }
    }

    private void bfsTraversal(List<Integer> nodes, int index) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(index);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (!nodes.contains(node)) {
                nodes.add(node);
                if (adjList.containsKey(node)) {
                    for (int child : adjList.get(node)) {
                        if (!queue.contains(child)) queue.add(child);
                    }
                }
            }
        }
    }

    private boolean isDirectedCyclic(boolean[] visited, boolean[] onStack, int node) {
        if (onStack[node]) return true;
        if (visited[node]) return false;
        visited[node] = true;
        onStack[node] = true;

        if (adjList.containsKey(node)) {
            for (int child : adjList.get(node)) {
                if (isDirectedCyclic(visited, onStack, child)) return true;
            }
        }

        onStack[node] = false;
        return false;
    }

    private boolean isUndirectedCyclic(boolean[] visited, int child, int parent) {
        visited[child] = true;
        if (adjList.containsKey(child)) {
            for (int node : adjList.get(child)) {
                if (!visited[node]) {
                    if (isUndirectedCyclic(visited, node, child)) return true;
                } else if (node != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
