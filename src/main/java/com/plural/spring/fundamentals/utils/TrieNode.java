package com.plural.spring.fundamentals.utils;

public class TrieNode {
    public char rootChar;
    public boolean isWord;
    public TrieNode[] children;

    public TrieNode(char rootChar, boolean isWord) {
        this.rootChar = rootChar;
        this.isWord = isWord;
        children = new TrieNode[26];
    }
}
