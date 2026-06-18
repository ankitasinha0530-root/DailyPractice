package com.dsal.recurssions;

import java.util.Arrays;

public class SudokuSolverCharInputOptimized {

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

//        System.out.println(sudokuSolver(sudoku1));
//        System.out.println(Arrays.deepToString(sudoku1));
//        System.out.println();
//
//        System.out.println(sudokuSolver(invalidSudoku));
//        System.out.println(Arrays.deepToString(invalidSudoku));
//        System.out.println();

    }

    private static boolean sudokuSolver(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char number = '1'; number <= '9'; number++) {
                        if (isSafe(board, i, j, number)) {
                            board[i][j] = number;
                            if (sudokuSolver(board)) {
                                System.out.println("Sudoku is solved, hence returning true");
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    System.out.println("cannot put numbers at row = " + i + ", col = " + j + " hence returning false" );
                    return false; // Sudoku cannot be solved as none of the numbers 1 to 9 can be put in any cell at thsi stage
                }
            }
        }
        return true;
    }

    private static boolean isSafe(char[][] board, int row, int col, char number){

        for(int k = 0; k < board.length; k++){

            if (board[k][col] == number || board[row][k] == number){
                return false;
            }
        }

        int rowStart = (int) (row - row % Math.sqrt(board.length));
        int colStart = (int) (col - col % Math.sqrt(board.length));

        for (int r = rowStart; r < rowStart + Math.sqrt(board.length) ; r++) {
            for (int c = colStart; c < colStart + Math.sqrt(board.length); c++) {
               if( board[r][c] == number ){
                   return false;
               }
            }

        }
        return true;
    }
}
