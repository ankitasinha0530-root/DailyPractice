package com.dsal.leetcode.blind75.trie.findandreturnword;

import java.util.ArrayList;
import java.util.List;

public class wordSearchReturnList {

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}};

        String[] words = {"oath", "neta", "aak", "oataer"};

        System.out.println(findWords(board, words));
        System.out.println();

    }

    //This will give Time Limit Exceeded error in LeetCode, so, implement using Trie

    public static List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (isWordExist(board, word, i, j, 0, visited)) {
                            if (!result.contains(word)) {
                                result.add(word);
                            }
                            break;
                        }
                    }

                }
            }
        }
        return result;
    }

    private static boolean isWordExist(char[][] board, String word, int row, int col, int idxWord, boolean[][] visited) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || visited[row][col]
                || board[row][col] != word.charAt(idxWord)) {
            return false;
        }

        if (idxWord == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;

        boolean found = isWordExist(board, word, row + 1, col, idxWord + 1, visited) ||
                isWordExist(board, word, row - 1, col, idxWord + 1, visited) ||
                isWordExist(board, word, row, col + 1, idxWord + 1, visited) ||
                isWordExist(board, word, row, col - 1, idxWord + 1, visited);

        visited[row][col] = false;

        return found;

    }
}
