package com.plural.spring.fundamentals.problems;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] costs = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && costs[i - coin] != -1) minCoins = Math.min(minCoins, 1 + costs[i - coin]);
            }
            costs[i] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        }
        return costs[amount];
    }
}
