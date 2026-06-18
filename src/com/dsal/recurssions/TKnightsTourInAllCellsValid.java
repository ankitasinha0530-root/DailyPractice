package com.dsal.recurssions;

import java.util.Arrays;

public class TKnightsTourInAllCellsValid {
    static boolean ans = false;
    public static void main(String[] args) {

        int n = 5, row = 0, col = 0;
        int[][] chessBoard = {
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}};

        int n1 = 9, row1 = 0, col1 = 0;
        int[][] chess1 = new int[n1][n1];

        System.out.println(validGridForKnightsFillAllCells(chessBoard, row, col, 0));
        System.out.println(validGridForKnightsFillAllCells(chess1, row1, col1, 0));
        System.out.println();

        validGridForKnightsFillAllCellsV2(chessBoard, row, col, 0);
        System.out.println(ans);

        System.out.println();
        System.out.println(validGridForKnightsFillAllCellsV3(chessBoard));
    }

    private static boolean validGridForKnightsFillAllCells(int[][] chessBoard, int row, int col, int expectedVal) {

        if (row < 0 || row >= chessBoard.length || col < 0 || col >= chessBoard.length || chessBoard[row][col] != expectedVal){
            return false;
        }
        if (expectedVal == chessBoard.length * chessBoard.length - 1){
            return true;
        }

        boolean ans1 = validGridForKnightsFillAllCells(chessBoard, row - 2, col + 1, expectedVal + 1);
        boolean ans2 = validGridForKnightsFillAllCells(chessBoard, row - 1, col + 2, expectedVal + 1);
        boolean ans3 = validGridForKnightsFillAllCells(chessBoard, row + 1, col + 2, expectedVal + 1);
        boolean ans4 = validGridForKnightsFillAllCells(chessBoard, row + 2, col + 1, expectedVal + 1);
        boolean ans5 = validGridForKnightsFillAllCells(chessBoard, row + 2, col - 1, expectedVal + 1);
        boolean ans6 = validGridForKnightsFillAllCells(chessBoard, row + 1, col - 2, expectedVal + 1);
        boolean ans7 = validGridForKnightsFillAllCells(chessBoard, row - 1, col - 2, expectedVal + 1);
        boolean ans8 = validGridForKnightsFillAllCells(chessBoard, row - 2, col - 1, expectedVal + 1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    private static void validGridForKnightsFillAllCellsV2(int[][] chessBoard, int row, int col, int expectedVal) {

        if(row < 0 || row >= chessBoard.length || col < 0 || col >= chessBoard.length || chessBoard[row][col] != expectedVal){
            return;
        }
        if( expectedVal == chessBoard.length * chessBoard.length - 1){
            ans = true;
            return;
        }

        validGridForKnightsFillAllCellsV2(chessBoard, row - 2, col + 1, expectedVal + 1);
        validGridForKnightsFillAllCellsV2(chessBoard, row - 1, col + 2, expectedVal + 1);
        validGridForKnightsFillAllCellsV2(chessBoard, row + 1, col + 2, expectedVal + 1);
        validGridForKnightsFillAllCellsV2(chessBoard, row + 2, col + 1, expectedVal + 1);
        validGridForKnightsFillAllCellsV2(chessBoard, row + 2, col - 1, expectedVal + 1);
        validGridForKnightsFillAllCellsV2(chessBoard, row + 1, col - 2, expectedVal + 1);
        validGridForKnightsFillAllCellsV2(chessBoard, row - 1, col - 2, expectedVal + 1);
        validGridForKnightsFillAllCellsV2(chessBoard, row - 2, col - 1, expectedVal + 1);

    }

    private static boolean validGridForKnightsFillAllCellsV3(int[][] chessBoard) {

        if(chessBoard[0][0] != 0){
            return false;
        }

        int n = chessBoard.length;

        int[][] directions = { {-2, -1}, {-1, -2}, {-2, 1}, {1, -2}, {1, 2}, {2, 1}, {-1, 2}, {2, -1} };

        int i = 0;
        int j = 0;

        for (int curr = 1; curr < n*n; curr++) {
            boolean found = false;

            for (int[] dir : directions){
                int newi = i + dir[0];
                int newj = j + dir[1];

                if(newi >= 0 && newi < n && newj >= 0 && newj < n && chessBoard[newi][newj] == curr){
                    i = newi;
                    j = newj;
                    found = true;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }
}
