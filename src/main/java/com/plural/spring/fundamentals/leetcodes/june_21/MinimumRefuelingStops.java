package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 06/12/2021
Problem Statement:
A car travels from a starting position to a destination which is target miles east of the starting position.
Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.
The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.
When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.
Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i <= n; i++) {
            int dist = i == n ? target : stations[i][0];
            while (startFuel < dist) {
                if (pq.isEmpty()) return -1;
                startFuel += pq.poll();
                ans++;
            }
            if (i < n) pq.add(stations[i][1]);
        }
        return ans;
    }
}
