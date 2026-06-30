package com.dsal.leetcode.blind75.matrix.dfs;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}};
        String word = "oath";
        String word1 = "rain";

        System.out.println(isWordExist(board, word));
        System.out.println(isWordExist(board, word1));
        System.out.println();
        System.out.println(isWordExist2(board, word));
        System.out.println(isWordExist2(board, word1));

    }

    private static boolean isWordExist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(!searchWord(board, word, i, j, 0, visited)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean searchWord(char[][] board, String word, int i, int j, int idxWord, boolean[][] visited ) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j]
        || word.charAt(idxWord) != board[i][j]) {
            return false;
        }

        if(idxWord == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;

        boolean found = searchWord(board, word, i+1, j, idxWord + 1, visited) ||
                searchWord(board, word, i - 1, j, idxWord + 1, visited) ||
                searchWord(board, word, i, j + 1, idxWord + 1, visited) ||
                searchWord(board, word, i, j - 1, idxWord + 1, visited);

        visited[i][j] = false;

        return found;
    }

    private static boolean isWordExist2(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(!searchWord2(board, word, i, j, 0, visited)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean searchWord2(char[][] board, String word, int i, int j, int idxWord, boolean[][] visited ) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j]
                || word.charAt(idxWord) != board[i][j]) {
            return false;
        }

        if(idxWord == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;

        if(searchWord2(board, word, i+1, j, idxWord + 1, visited) ||
                searchWord2(board, word, i - 1, j, idxWord + 1, visited) ||
                searchWord2(board, word, i, j + 1, idxWord + 1, visited) ||
                searchWord2(board, word, i, j - 1, idxWord + 1, visited)) {
            visited[i][j] = false;
            return true;
        }

        visited[i][j] = false;

        return false;
    }
}
