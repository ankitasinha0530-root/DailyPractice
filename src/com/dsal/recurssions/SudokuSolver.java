package com.dsal.recurssions;

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {

        int[][] sudoku = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},

                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},

                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        int[][] sudoku1 = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        int[][] invalidSudoku = {
                {5, 5, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
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

    private static boolean sudokuSolver(int[][] board){

        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        // find the empty row cell .. row, col
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0){
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

        for (int number = 1; number <= 9; number++) {
            if(isSafe(board, row, col, number)){
                board[row][col] = number;
                if(sudokuSolver(board)){ // Sudoku is solved
                    return true;
                }
                board[row][col] = 0; //backtrack
            }

        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num){

        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num){
                return false;
            }
        }

        for (int[] nums : board){
            if(nums[col] == num){
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt ; c++) {
                if(board[r][c] == num){
                    return false;
                }
            }
        }

        return true;
    }
}
