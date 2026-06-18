package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SNQueensPlacementCountWays {

    public static void main(String[] args) {

        System.out.println(solveNQueensPlacementWays(4)); // 2 ways

        System.out.println();
        System.out.println(solveNQueensPlacementWays(5)); // 12 ways

        System.out.println();
        System.out.println(solveNQueensPlacementWays(9)); // 364 ways

    }

    static int count = 0;
    private static int solveNQueensPlacementWays(int n) {

        int[][] board = new int[n][n];

        int row = 0;
        solveNQueensPlacementWaysCount(n, board, row);

        return count;
    }

    private static void solveNQueensPlacementWaysCount(int n, int[][] chessBoard, int row) {

        if(row == chessBoard.length) {
            count++;
            System.out.println(Arrays.deepToString(chessBoard));
            System.out.println();
            return;
        }

        for (int col = 0; col < chessBoard.length; col++) {

            if(isItSafePlaceForTheQueen(chessBoard, row, col)) {
                chessBoard[row][col] = 1;

                solveNQueensPlacementWaysCount(n, chessBoard, row + 1);
                chessBoard[row][col] = 0;
            }
        }
    }

    private static boolean isItSafePlaceForTheQueen(int[][] chessBoard, int row, int col) {

        for (int i = row - 1, j = col ; i >=0 ; i--) {
            if (chessBoard[i][j] == 1){
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 1){
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >=0 && j < chessBoard.length; i--, j++) {
            if (chessBoard[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    private static void nQueenPlacement(int[][] chessBoard, int row, String qsf) {

        if(row == chessBoard.length) {
            System.out.println("Queens placed : " + qsf);
        }

        for (int col = 0; col < chessBoard.length; col++) {

            if(isItSafePlaceForTheQueen(chessBoard, row, col)) {
                chessBoard[row][col] = 1;
                nQueenPlacement(chessBoard, row + 1, qsf + row + "-" + col + ", " );
                chessBoard[row][col] = 0;
            }
        }
    }

}
