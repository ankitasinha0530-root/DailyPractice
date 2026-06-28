package com.dsal.leetcode.blind75.trie.findandreturnword;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/word-search-ii/submissions/2048948528/

public class FindAndReturnWordFromDictUSingTrie {

    static TrieNode root = new TrieNode();
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}};

        String[] words = {"oath", "neta", "aak", "oataer"};

        System.out.println(findWordsUsingTrie(board, words));
        System.out.println(result);
    }

    private static List<String> findWordsUsingTrie(char[][] board, String[] words) {
        // insert the given words in Trie

        for (String word : words) {
            insertInTrie(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                searchWordDfs(board, i, j, root, result);
            }
        }
        System.out.println("Result : " + result);
        return result;
    }

    private static void searchWordDfs(char[][] board, int i, int j, TrieNode root, List<String> result) {

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') {
            return;
        }

        char ch = board[i][j];

        if(root.children[ch - 'a'] == null) { // if no children then simply return
            return;
        }

        root = root.children[ch - 'a']; // Board gave us character 'e', so move Trie from root -> next char

        if(root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        board[i][j] = '#';

        searchWordDfs(board, i + 1, j, root, result);
        searchWordDfs(board, i - 1, j, root, result);
        searchWordDfs(board, i, j + 1, root, result);
        searchWordDfs(board, i, j - 1, root, result);

        board[i][j] = ch;

    }

    private static void insertInTrie(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            if(current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }
            current = current.children[ch - 'a'];
        }
        current.word = word;
    }

}
