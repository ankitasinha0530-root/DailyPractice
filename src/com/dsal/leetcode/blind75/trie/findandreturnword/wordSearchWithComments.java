package com.dsal.leetcode.blind75.trie.findandreturnword;

import java.util.ArrayList;
import java.util.List;

public class wordSearchWithComments {


    // Each Trie node represents one character in a prefix.
    class TrieNode {

        // References to next characters.
        // children[0] -> 'a'
        // children[1] -> 'b'
        // ...
        // children[25] -> 'z'
        TrieNode[] children = new TrieNode[26];

        // Stores complete word when this node is the end of a word.
        // Example:
        // root -> e -> a -> t
        // node at 't' stores "eat"
        String word;
    }

    // Root represents empty prefix ""
    TrieNode root = new TrieNode();

    // Final answer.
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        //-------------------------------------------------------
        // STEP 1 : Insert every dictionary word into Trie.
        //-------------------------------------------------------
        for (String word : words) {
            insert(word);
        }

        //-------------------------------------------------------
        // STEP 2 : Start DFS from EVERY board cell because
        // we don't know where a word begins.
        //-------------------------------------------------------
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // Start with root because initially
                // we haven't matched any character.
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void dfs(char[][] board,
                     int row,
                     int col,
                     TrieNode node) {

        //-------------------------------------------------------
        // BASE CONDITION 1
        // Invalid board position.
        //-------------------------------------------------------
        if (row < 0 ||
                col < 0 ||
                row >= board.length ||
                col >= board[0].length) {
            return;
        }

        //-------------------------------------------------------
        // BASE CONDITION 2
        // Already visited.
        //-------------------------------------------------------
        if (board[row][col] == '#') {
            return;
        }

        //-------------------------------------------------------
        // Current board character.
        //-------------------------------------------------------
        char ch = board[row][col];

        //-------------------------------------------------------
        // BASE CONDITION 3
        //
        // This is the MOST IMPORTANT line.
        //
        // It checks:
        // "Can any word continue with this character?"
        //
        // If node == root, it means:
        // "Can any word START with this character?"
        //-------------------------------------------------------
        if (node.children[ch - 'a'] == null) {
            return;
        }

        //-------------------------------------------------------
        // Move Trie pointer.
        //
        // Board gave us character 'e',
        // so move Trie from:
        //
        // root -> e
        //
        // Board and Trie stay synchronized.
        //-------------------------------------------------------
        node = node.children[ch - 'a'];

        //-------------------------------------------------------
        // If this Trie node stores a word,
        // then board path formed a complete word.
        //-------------------------------------------------------
        if (node.word != null) {

            result.add(node.word);

            // Avoid duplicates.
            node.word = null;
        }

        //-------------------------------------------------------
        // Mark current board cell visited.
        //-------------------------------------------------------
        board[row][col] = '#';

        //-------------------------------------------------------
        // Explore all four directions.
        //-------------------------------------------------------
        dfs(board, row + 1, col, node); // down
        dfs(board, row - 1, col, node); // up
        dfs(board, row, col + 1, node); // right
        dfs(board, row, col - 1, node); // left

        //-------------------------------------------------------
        // Backtrack.
        //
        // Restore original character so that another
        // DFS path can reuse this cell.
        //-------------------------------------------------------
        board[row][col] = ch;
    }

    private void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            // Create node if character doesn't exist.
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            // Move to next character.
            current = current.children[index];
        }

        // Store entire word at the last character.
        current.word = word;
    }
}
