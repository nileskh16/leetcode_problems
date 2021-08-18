package com.plural.spring.fundamentals.leetcodes.july_21;

/*
Date: 07/24/2021
Problem Statement:
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList,
return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 */

import java.util.*;

public class WordLadderII {

    private class Node {
        String value;
        int depth;
        Node parent;

        Node(String value, int depth, Node parent) {
            this.value = value;
            this.depth = depth;
            this.parent = parent;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Deque<Node> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Set<String> dic = new HashSet<>(wordList);

        int minDepth = Integer.MAX_VALUE;
        int level = 0;
        q.add(new Node(beginWord, 0, null));

        while (!q.isEmpty()) {
            List<Node> mediate = new ArrayList<>();
            while (!q.isEmpty()) mediate.add(q.poll());
            level++;

            if (level > minDepth) break;

            for (Node cur : mediate) {
                if (cur.value.equals(endWord)) {
                    minDepth = cur.depth;
                    result.add(wordLadder(cur));
                }
                visited.add(cur.value);

                for (String word : findWords(cur.value, dic)) {
                    if (!visited.contains(word)) q.offer(new Node(word, cur.depth + 1, cur));
                }
            }
        }
        return result;
    }

    private List<String> findWords(String s, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] c = s.toCharArray();
            for (char x = 'a'; x <= 'z'; x++) {
                c[i] = x;
                String word = String.valueOf(c);
                if (dict.contains(word)) {
                    result.add(word);
                }
            }
        }
        return result;
    }

    private List<String> wordLadder(Node curr) {
        Deque<String> ladder = new ArrayDeque<>();
        while (curr != null) {
            ladder.offerFirst(curr.value);
            curr = curr.parent;
        }
        return new ArrayList<>(ladder);
    }
}
