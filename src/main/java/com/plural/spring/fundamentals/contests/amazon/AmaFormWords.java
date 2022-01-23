package com.plural.spring.fundamentals.contests.amazon;

import com.plural.spring.fundamentals.utils.TrieNode;

import java.util.*;

public class AmaFormWords {

    private final TrieNode root;
    private final Map<String, List<List<String>>> answer = new HashMap<>();

    {
        root = new TrieNode('0', false);
    }

    public static void main(String[] args) {
        runArray();
    }

    private static void runArray() {
        int[] arr = new int[] {35, 53, 40};
        long product = 1;
        for (int num : arr) product *= num;
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = (int) (product / arr[i]);
        }

        System.out.println(Arrays.toString(ans));
    }

    private static void runWordForm() {
        List<String> words = Arrays.asList("happy", "rise", "for", "set", "sunrise", "su", "sun", "nset", "sunset", "mind", "happymind", "n", "happysunrise");
        new AmaFormWords().processWords(words);
    }

    private void processWords(List<String> words) {
        words.sort((String a, String b) -> a.length() == b.length() ? a.compareTo(b) : Integer.compare(a.length(), b.length()));
        for (String word : words) {
            answer.put(word, searchWord(word));
        }
        System.out.println(answer);
    }

    private void addWord(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = new TrieNode(ch, i == word.length() - 1);
            currentNode.children[ch - 'a'] = node;
            currentNode = node;
        }
    }

    private List<List<String>> searchWord(String word) {
        if (answer.containsKey(word)) return answer.get(word);
        List<List<String>> sub = new ArrayList<>();
        if (word.isEmpty()) return sub;
        int i = 0;
        TrieNode currentNode = root;
        while (i < word.length()) {
            if (currentNode.isWord) {
                String subWord = word.substring(0, i);
                List<List<String>> temp = searchWord(word.substring(i));
                if (!temp.isEmpty()) {
                    for (List<String> s : temp) {
                        List<String> ns = new ArrayList<>(s);
                        ns.add(subWord);
                        sub.add(ns);
                    }
                }
            }
            char ch = word.charAt(i);
            if (currentNode.children[ch - 'a'] != null) {
                currentNode = currentNode.children[ch - 'a'];
            } else {
                break;
            }
            i++;
        }
        addWord(word);
        sub.add(Collections.singletonList(word));
        return sub;
    }
}
