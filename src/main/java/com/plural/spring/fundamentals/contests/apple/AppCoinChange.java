package com.plural.spring.fundamentals.contests.apple;

import java.util.*;

public class AppCoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i == coin) { minVal = 1; break; }
                else if (i > coin) {
                    int diff = i - coin;
                    if (dp[diff] != -1) minVal = Math.min(minVal, dp[coin] + dp[diff]);
                }
            }
            dp[i] = minVal == Integer.MAX_VALUE ? -1 : minVal;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 5, 6, 4, 5};
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) return Integer.compare(o2.getKey(), o1.getKey());
            else return Integer.compare(o1.getValue(), o2.getValue());
        });

        queue.addAll(map.entrySet());

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int val = entry.getValue();
            int key = entry.getKey();
            for (int i = 0; i < val; i++) {
                ans.add(key);
            }
        }

        ans.forEach(System.out::println);
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

    }
}
