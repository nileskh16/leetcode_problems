package com.plural.spring.fundamentals.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Interview {

    public static void main(String[] args) {
        useStreams();
    }

    private static List<Integer> findPeaks(int[] numberOfPatients) {
        List<Integer> answer = new ArrayList<>(numberOfPatients.length);
        if (numberOfPatients.length == 0) return answer;
        List<Integer> unique = uniqueElements(numberOfPatients);
        for (int i = 0; i < unique.size(); i++) {
            int prev = i == 0 ? i : i - 1;
            int next = i == unique.size() - 1 ? unique.size() - 1 : i + 1;
            if (unique.get(i) > unique.get(prev) && unique.get(i) > unique.get(next)) {
                answer.add(numberOfPatients[i]);
            }
        }
        return answer;
    }

    private static List<Integer> uniqueElements(int[] numOfPatients) {
        List<Integer> arr = new ArrayList<>(numOfPatients.length);
        for (int num : numOfPatients) {
            if (!arr.contains(num)) arr.add(num);
        }
        return arr;
    }
    
    private static void sortObjects() {
        Object[] arr = new Object[] {
                new Integer(7),
                new String("foo"),
                new Integer(15),
                new Boolean(false)};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }

    private static void testInheritance() {
        class A {};
        class B extends A {};

        A[] arrA = new A[10];
        B[] arrB = new B[20];
        arrA = arrB;
        arrB = (B[]) arrA;

        arrA = new A[15];
    }

    private static void useStreams() {
        Stream<String> words = Stream.of("One", "two", "three");
        int ans = words.mapToInt(String::length).reduce(0, (int l1, int l2) -> l1 + l2);
        System.out.println(ans);
    }
}
