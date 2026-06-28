package com.dsal.leetcode.blind75.trie;

public class MyTrie {

    TrieNode trieNode;

    public MyTrie () {
        trieNode = new TrieNode();
    }

    public void add(String word) {

        TrieNode current = trieNode;

        char[] wordArr = word.toCharArray();

        for (int i = 0; i < wordArr.length; i++) {

            char ch = word.charAt(i);

            if(current.children[ch-'a'] == null) {
                current.children[ch-'a'] = new TrieNode();
            }
            current = current.children[ch-'a'];
        }
        trieNode.isWord = true;
    }

    public boolean search(String word) {

        TrieNode current = trieNode;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if(current.children[ch-'a'] == null) {
                return false;
            }
            current = current.children[ch-'a'];
        }
        return trieNode.isWord;
    }

    public boolean startsWith(String prefix) {

        TrieNode current = trieNode;

        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);

            if(current.children[ch-'a'] == null) {
                return false;
            }
        }
        return true;
    }

    public TrieNode delete(String word) {

        TrieNode current = trieNode;

        return deleteHelper(current, word, 0);
    }

    private TrieNode deleteHelper(TrieNode root, String word, int i) {
        
        if (root == null) {
            return null;
        }
        if (i == word.length()) {
            root.isWord = false;
            if(isRootEmpty(root)){
                root = null;
            }
            return root;
        }
        char ch = word.charAt(i);
        root.children[ch-'a'] = deleteHelper(root.children[ch - 'a'], word, i + 1);

        if (isRootEmpty(root) && !root.isWord) {
            root = null;
        }
        return root;
    }

    private boolean isRootEmpty(TrieNode root) {

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // https://www.youtube.com/watch?v=T1M52UqQq3c
        // -- delete trie node - https://www.youtube.com/watch?v=fzGVMOmBQWo

        MyTrie trie = new MyTrie();

        trie.add("cat");
        trie.add("car");
        trie.add("dog");

        trie.printTrie();
        System.out.println();

        System.out.println(trie.search("cat")); // true
        System.out.println(trie.search("car")); // true
        System.out.println(trie.search("dog")); // true

        System.out.println(trie.search("ca"));  // false
        System.out.println(trie.search("do"));  // false
        System.out.println(trie.search("bat")); // false

        System.out.println(trie.startsWith("ca")); // true
        System.out.println(trie.startsWith("do")); // true
        System.out.println(trie.startsWith("ba")); // false

        System.out.println(trie.delete("cat")); // false

        trie.printTrie();
    }

    public void printTrie() {
        dfs(trieNode, "");
    }

    private void dfs(TrieNode node, String word) {

        if (node.isWord) {
            System.out.println(word);
        }

        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                char ch = (char) ('a' + i);

                dfs(node.children[i], word + ch);
            }
        }
    }
}
