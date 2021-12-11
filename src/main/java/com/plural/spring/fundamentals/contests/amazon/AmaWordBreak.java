package com.plural.spring.fundamentals.contests.amazon;

import java.util.HashMap;
import java.util.Map;

public class AmaWordBreak {

    public boolean isValidWord(String[] wordList, String targetWord) {
        Trie trie = new Trie(targetWord);

        for (String word : wordList) {
            trie.insert(word);
        }

        return trie.find();
    }

    private String removeString(String source, String sub) {
        return source.contains(sub) ? source.replaceAll(sub, "") : source;
    }

    static class Trie {
        String s;
        Node root;
        Map<Integer, Boolean> map = new HashMap<>();

        public Trie(String s) {
            this.s = s;
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                int id = ch - 'a';
                if (node.children[id] == null) node.children[id] = new Node();
                node = node.children[id];
            }
            node.isWord = true;
        }

        public boolean find() {
            return search(root, 0, 0);
        }

        private boolean search(Node node, int id, int count) {
            char ch = s.charAt(id);
            if (node.children[ch - 'a'] == null) return false;
            id++;
            node = node.children[ch - 'a'];
            boolean x = false, y = false;
            if (node.isWord) {
                count++;
                if (id >= s.length()) x = count > 0;
                else {
                    x = search(node, id, count - 1);
                    if (map.containsKey(id)) y = map.get(id);
                    else {
                        y = search(root, id, count);
                        map.put(id, y);
                    }
                }
            } else {
                y = id < s.length() && search(node, id, count);
            }

            return x || y;
        }
    }

    static class Node {
        Node[] children = new Node[26];
        boolean isWord = false;
    }
}
