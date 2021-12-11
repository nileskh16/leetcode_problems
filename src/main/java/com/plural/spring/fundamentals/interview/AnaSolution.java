package com.plural.spring.fundamentals.interview;

import java.util.*;

public class AnaSolution {

    public static void main(String[] args) {
        if (args.length <= 0) return;
        Map<String, Integer> countMap = new HashMap<>(args.length);
        List<Word> wordList = new ArrayList<>(args.length);
        for (int i = 0; i < args.length; i++) {
            char[] tempArr = args[i].toCharArray();
            Arrays.sort(tempArr);
            wordList.add(new Word(new String(tempArr), i));
        }

        /*
            select name, count from Student where(count(*) from Employee group by name > 1);
         */

        for (Word word : wordList) {
            countMap.put(word.getName(), countMap.getOrDefault(word.getName(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println("For anagram " + entry.getKey() + " count: " + entry.getValue());
        }
    }

    private static class Word {
        private int id;
        private String name;

        Word(String name, int id) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
