package com.plural.spring.fundamentals.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    private final Map<Integer, List<Integer>> map = new HashMap<>();
    private int firstCourse = 0;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        constructGraph(prerequisites);

        for (int key : map.keySet()) {
            if (isCyclic(visited, onStack, key)) return false;
        }
        return true;
    }

    private void constructGraph(int[][] edges) {
        for (int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            int fromNode = edge[1];
            int toNode = edge[0];
            if (i == 0) firstCourse = fromNode;
            addEdgeToGraph(fromNode, toNode);
        }
    }

    private void addEdgeToGraph(int from, int to) {
        if (!map.containsKey(from)) {
            map.put(from, new ArrayList<>());
        }
        map.get(from).add(to);
    }

    private boolean isCyclic(boolean[] visited, boolean[] onStack, int node) {
        if (onStack[node]) return true;
        if (visited[node]) return false;
        visited[node] = true;
        onStack[node] = true;

        if (map.containsKey(node)) {
            for (int child : map.get(node)) {
                if (isCyclic(visited, onStack, child)) return true;
            }
        }

        onStack[node] = false;
        return false;
    }
}
