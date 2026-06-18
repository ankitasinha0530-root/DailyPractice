package com.dsal.recurssions;

import java.util.Arrays;

public class SudokuSolverCharInput {

    public static void main(String[] args) {

        char[][] sudoku = {
                {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
                {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '8', '7', '.', '.', '.', '.', '3', '1'},

                {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
                {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
                {'.', '5', '.', '.', '9', '.', '6', '.', '.'},

                {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
                {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
        };

        char[][] sudoku1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] invalidSudoku = {
                {'5', '5', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(sudokuSolver(sudoku));
        System.out.println(Arrays.deepToString(sudoku));
        System.out.println();

        System.out.println(sudokuSolver(sudoku1));
        System.out.println(Arrays.deepToString(sudoku1));
        System.out.println();

        System.out.println(sudokuSolver(invalidSudoku));
        System.out.println(Arrays.deepToString(invalidSudoku));
        System.out.println();

    }

    private static boolean sudokuSolver(char[][] board){

        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        // find the empty row cell .. row, col
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == '.'){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(!emptyLeft){ // no need to go for next row as the empty is already, found hence break
                break;
            }
        }

        if(emptyLeft){ // if emptyLeft remains true it means that there are no empty cells, Sudoku is solved hence return true;
            return true;
        }

        for (char number = '1'; number <= '9'; number++) {
            if(isSafe(board, row, col, number)){
                board[row][col] = number;
                if(sudokuSolver(board)){ // Sudoku is solved
                    return true;
                }
                board[row][col] = '.'; //backtrack
            }

        }
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, int number){

        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == number){
                return false;
            }
        }

        for (char[] nums : board){
            if(nums[col] == number){
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt ; c++) {
                if(board[r][c] == number){
                    return false;
                }
            }
        }

        return true;
    }
}
