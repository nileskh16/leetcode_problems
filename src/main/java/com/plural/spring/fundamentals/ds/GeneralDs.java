package com.plural.spring.fundamentals.ds;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class GeneralDs {

    public static void main(String[] args) {
        checkSets();
    }

    private static void checkSets() {
        Set<Integer> unOrderedSet = new HashSet<>();
        Set<Integer> orderedSet = new LinkedHashSet<>();
        fillSet(unOrderedSet);
        fillSet(orderedSet);
        iterateSet(unOrderedSet);
        iterateSet(orderedSet);
    }

    private static void fillSet(Set<Integer> set) {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(4);
        set.add(6);
        set.add(8);
        set.add(10);
        set.add(9);
        set.add(11);
        set.add(7);
    }

    private static void iterateSet(Set<Integer> set) {
        for (Integer num : set) {
            System.out.printf(" %d =>", num);
        }
        System.out.println("");
    }
}
