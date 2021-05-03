package com.plural.spring.fundamentals.contests;

import java.util.PriorityQueue;
import java.util.Queue;

public class Biweekly51 {

    private Queue<Integer> seats = new PriorityQueue<>();

    public static void main(String[] args) {
        Biweekly51 biweekly51 = new Biweekly51();
//        System.out.println(biweekly51.replaceCharacters("a1b2c3d4e"));
        biweekly51.runReservationManager();
    }

    public String replaceCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(chars[i]);
            } else {
                sb.append(shiftChar(chars[i - 1], Integer.parseInt(s.substring(i, i + 1))));
            }
        }
        return sb.toString();
    }

    public void initialize(int n) {
        for (int i = 1; i <= n; i++) {
            seats.add(i);
        }
    }

    public int reserve() {
        return seats.poll();
    }

    public void unreserve(int seatNumber) {
        if (!seats.contains(seatNumber)) {
            seats.add(seatNumber);
        }
    }

    private void runReservationManager() {
        initialize(5);
        System.out.println(reserve());
        System.out.println(reserve());
        unreserve(2);
        System.out.println(reserve());
        System.out.println(reserve());
        System.out.println(reserve());
        System.out.println(reserve());
        unreserve(5);
    }

    private char shiftChar(char c, int x) {
        return (char) ((int) c + x);
    }
}
