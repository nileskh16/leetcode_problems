package com.plural.spring.fundamentals.problems.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(add(5, 5));
        new ArrayList<Integer>().stream().sorted(Integer::compareTo).collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(ans, visited, nums, new ArrayList<>());
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, boolean[] visited, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            backTrack(ans, visited, nums, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    private static int add(int a, int b) {
        try {
            return a + b;
        } finally {
            return 0;
        }
    }
}
