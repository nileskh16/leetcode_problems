package com.plural.spring.fundamentals.leetcodes.april_21;

public class JumpingGameTwo {

    public static void main(String[] args) {
        JumpingGameTwo gameTwo = new JumpingGameTwo();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(gameTwo.minJumps(nums));
    }

    public int minJumps(int[] nums) {
        int jumps = 0;
        int index = 0;
        int lastIndex = 0;
        for (int i = 0; i <= index && i < nums.length; i++) {
            if (i > lastIndex) {
                lastIndex = index;
                jumps++;
            }
            index = Math.max(index, nums[i] + i);
        }
        return jumps;
    }

    private int findNextBigIndex(int[] nums, int index, int num) {
        int lastIndex = nums.length - 1;
        int distance = lastIndex - index - 1;
        int nextBigInt = num;
        int nextBigIndex = index;
        int stopIndex = num < distance ? lastIndex - 1 : num;

        for (int i = index; i < stopIndex; i++) {
            if (nextBigInt <= nums[i]) {
                nextBigInt = nums[i];
                nextBigIndex = i;
            }
        }
        return nextBigIndex == index ? -1 : nextBigIndex;
    }
}
