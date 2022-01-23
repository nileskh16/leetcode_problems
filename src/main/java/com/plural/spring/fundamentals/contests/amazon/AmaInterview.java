package com.plural.spring.fundamentals.contests.amazon;

import java.util.*;

public class AmaInterview {

    public static void main(String[] args) {
//        sortArraysWithMinSwaps(new int[]{1, 1, 1, 1, 0, 1, 0, 0, 0, 0});
//        sortArraysWithMinSwaps(new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0, 0});
//        sortArraysWithMinSwaps(new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0});
//        sortArraysWithMinSwaps(new int[]{0, 0, 0, 0, 1, 1, 1, 0, 1});
//        sortArraysWithMinSwaps(new int[]{1, 1, 1, 1, 0, 1, 0, 1});
//        sortArraysWithMinSwaps(new int[]{0, 0, 1, 0, 1, 0, 1, 1});

        System.out.println(subarraySum(new int[]{-4,-3,-2,-1,0}, -3));
    }

    private static List<Integer> splitArray(Integer[] input) {
        Arrays.sort(input, (a, b) -> Integer.compare(b, a));
        int n = input.length;
        int mid = (n / 2) - 1;
        int firstSum = 0, secondSum = 0;
        for (int i = 0; i < n; i++) {
            if (i <= mid) firstSum += input[i];
            else secondSum += input[i];
        }
        while (firstSum < secondSum && mid >= 0) {
            firstSum -= input[mid];
            secondSum += input[mid];
            mid--;
        }
        if (mid < 0) return null;
        return new LinkedList<>(Arrays.asList(input).subList(0, mid + 1));
    }

    private static void sortArrayOfZOT(int[] input) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int num : input) {
            if (num == 0) zeroCount++;
            else if (num == 1) oneCount++;
            else twoCount++;
        }
        int index = 0;
        while (zeroCount > 0) {
            input[index] = 0;
            index++;
            zeroCount--;
        }

        while (oneCount > 0) {
            input[index] = 1;
            index++;
            oneCount--;
        }

        while (twoCount > 0) {
            input[index] = 2;
            index++;
            twoCount--;
        }
    }

    private static void dutchFlagSort(int[] input) {
        int low = 0, mid = 0, high = input.length - 1;
        while (mid <= high) {
            if (input[mid] == 0) {
                swap(input, low, mid);
                mid++;
                low++;
            } else if (input[mid] == 2) {
                swap(input, mid, high);
                high--;
            } else mid++;
        }
    }

    private static void sortArraysWithMinSwaps(int[] input) {
        System.out.println(Arrays.toString(input));
        int moves = input.length;
        moves = Math.min(moves, sortOnesAndZeroes(Arrays.copyOf(input, input.length), false));
        moves = Math.min(moves, sortOnesAndZeroes(Arrays.copyOf(input, input.length), true));
        System.out.println(moves);
    }

    private static int sortOnesAndZeroes(int[] arr, boolean desc) {
        int left = 0, right = 0, n = arr.length, moves = 0;
        while (left < n && right < n) {
            while (left < n && ((desc && arr[left] == 1) || (!desc && arr[left] == 0))) left++;
            right = left;
            while (right < n && ((desc && arr[right] == 0) || (!desc && arr[right] == 1))) right++;
            if (right < n) {
                swap(arr, left, right);
                moves += (right - left);
                left++;
            }
        }
        return moves;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<List<Integer>>> ans = new HashMap<>();
        List<Integer> visited = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> mid = new ArrayList<>();
            for (int cd : candidates) {
                if (cd < i) {
                    int diff = i - cd;
                    int mn = Math.min(diff, cd);
                    int mx = Math.max(diff, cd);
                    if (!visited.contains(mn) && ans.containsKey(mn) && ans.containsKey(mx)) {
                        List<List<Integer>> temp = ans.get(mx);
                        for (List<Integer> ls : temp) {
                            List<Integer> s = new ArrayList<>(ls);
                            s.add(mn);
                            mid.add(s);
                        }
                        visited.add(mn);
                        visited.add(mx);
                    }
                } else if (cd == i) {
                    mid.add(Arrays.asList(i));
                    visited.add(cd);
                }
            }
            visited.clear();
            if (!mid.isEmpty()) ans.put(i, mid);
        }

        return ans.get(target);
    }

    private static int subarraySum(int[] nums, int k) {
        int i = 0, j = 0, sum = 0, ans = 0, n = nums.length;
        while (i < n && j < n) {
            while (sum != k && j < n) {
                sum += nums[j];
                j++;
            }
            if (sum == k) {
                ans++;
                sum -= nums[i];
                i++;
            }
        }

        if (i < j) {
            while (i < j) {
                if (sum == k) ans++;
                sum -= nums[i];
                i++;
            }
        } else if (sum == k) {
            ans++;
        }

        return ans;
    }
}
