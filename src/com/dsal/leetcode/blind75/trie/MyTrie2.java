package com.dsal.leetcode.blind75.trie;

public class MyTrie2 {

    TrieNode trieNode;

    public MyTrie2() {
        trieNode = new TrieNode();
    }

    public void add(String word) {

        TrieNode current = trieNode;

        for (char ch : word.toCharArray()) {

            if(current.children[ch-'a'] == null) {
                current.children[ch-'a'] = new TrieNode();
            }
            current = current.children[ch-'a'];
        }
        trieNode.isWord = true;
    }

    public boolean search(String word) {

        TrieNode current = trieNode;

        for (char ch : word.toCharArray()) {

            if(current.children[ch-'a'] == null) {
                return false;
            }
            current = current.children[ch-'a'];
        }
        return trieNode.isWord;
    }

    public boolean startsWith(String prefix) {

        TrieNode current = trieNode;

        for (char ch : prefix.toCharArray()) {

            if(current.children[ch-'a'] == null) {
                return false;
            }
        }
        return true;
    }

    public TrieNode delete (String word) {

        TrieNode node = trieNode;

        if (node == null) {
            return null;
        }

        return deleteTrieNode(node, word, 0);

    }

    // https://www.geeksforgeeks.org/videos/trie-delete-m3va2t/
    // always dry for run for 3 words, Zoo, an and and
    private TrieNode deleteTrieNode(TrieNode node, String word, int idxWord) {

        if (node == null) {
            return null;
        }

        if (isRootEmpty(node)){
            node.isWord = false; // if at last character of the word, as it's not a word anymore

            // to check if this root has any child, if yes then simply return,
            // check all the 26 characters to see if there is any child in any of the 26 index
            // else if there is no child then mark the node as null;
            if (isRootEmpty(node)){
                node = null;
            }
            return node;
        }

        char ch = word.charAt(idxWord);

        node.children[ch - 'a'] = deleteTrieNode(node.children[ch - 'a'], word, idxWord + 1);

        // to check if this root has any child, if yes then simply return,
        // check all the 26 characters to see if there is any child in any of the 26 index
        // else if there is no child then mark the node as null;
        // if the is Word is Marked as false; then mark the roo as null
        if (isRootEmpty(node) && !node.isWord) {
            node = null;
        }
        return node;
    }

    // check all the 26 characters to see if there is any child in any of the 26 index
    // if there is a child return false, if all the index are empty then return true;
    private boolean isRootEmpty(TrieNode node) {

        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // https://www.youtube.com/watch?v=T1M52UqQq3c
        // -- delete trie node - https://www.youtube.com/watch?v=fzGVMOmBQWo

        MyTrie2 trie = new MyTrie2();

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
