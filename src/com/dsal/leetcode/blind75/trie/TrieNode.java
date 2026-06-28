package com.dsal.leetcode.blind75.trie;

public class TrieNode {

    TrieNode[] children;

    boolean isWord;

    public TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
}
