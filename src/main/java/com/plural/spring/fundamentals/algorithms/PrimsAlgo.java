package com.plural.spring.fundamentals.algorithms;

import java.util.Arrays;

public class PrimsAlgo {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 4, 4, 0, 0, 0}, {4, 0, 2, 0, 0, 0}, {4, 2, 0, 3, 2, 4}, {0, 0, 3, 0, 0, 3},
                {0, 0, 2, 0, 0, 3}, {0, 0, 4, 3, 3, 0}};
        int v = 6;
        int startNode = 0;
        System.out.println("MST of the graph is: " + findMST(graph, v));
        System.out.println("Shortest distance to every node from: " + startNode + " is " + Arrays.toString(calculateMinDistance(graph, v, startNode)));
    }

    public static int findMST(int[][] graph, int v) {
        int weight = 0;
        int selectedNodes = 1;
        boolean[] visited = new boolean[v];

        visited[0] = true;

        while (selectedNodes < v) {
            int min = Integer.MAX_VALUE;
            int nextNode = -1;
            int currentNode = -1;
            for (int i = 0; i < v; i++) {
                if (visited[i]) {
                    for (int j = 0; j < v; j++) {
                        if (!visited[j] && graph[i][j] != 0) {
                            if (min > graph[i][j]) {
                                min = graph[i][j];
                                nextNode = j;
                                currentNode = i;
                            }
                        }
                    }
                }
            }

            if (nextNode != -1) {
                System.out.println("Adding new edge from " + currentNode + " -> " + nextNode + " with weight " + min);
                weight += min;
                visited[nextNode] = true;
                selectedNodes++;
            }
        }

        return weight;
    }

    public static int[] calculateMinDistance(int[][] graph, int v, int startNode) {
        int[] distance = new int[v];
        boolean[] visited = new boolean[v];

        int selectedNodes = 1;
        visited[startNode] = true;
        distance[startNode] = 0;

        while (selectedNodes < v) {
            int min = Integer.MAX_VALUE;
            int nextNode = -1;
            for (int i = 0; i < v; i++) {
                if (visited[i]) {
                    for (int j = 0; j < v; j++) {
                        if (!visited[j] && graph[i][j] != 0) {
                            int dist = distance[i] + graph[i][j];
                            if (min > dist) {
                                min = dist;
                                nextNode = j;
                            }
                        }
                    }
                }
            }

            if (nextNode != -1) {
                distance[nextNode] = min;
                visited[nextNode] = true;
                selectedNodes++;
            }
        }

        return distance;
    }
}
