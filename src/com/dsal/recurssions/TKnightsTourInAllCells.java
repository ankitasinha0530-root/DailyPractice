package com.dsal.recurssions;

import java.util.Arrays;

public class TKnightsTourInAllCells {

    public static void main(String[] args) {
        int n = 5, row = 0, col = 0;
        int[][] chess = new int[n][n];

        int n1 = 9, row1 = 5, col1 = 4;
        int[][] chess1 = new int[n1][n1];

        printKnightsTourWhenAllCellsFill(chess, row, col, 1);
//        printKnightsTourWhenAllCellsFill(chess1, row1, col1, 1);
    }

    private static void printKnightsTourWhenAllCellsFill(int[][] chessBoard, int row, int col, int move) {

        if(row < 0 || col < 0 || row >= chessBoard.length || col >= chessBoard.length || chessBoard[row][col] > 0){
            return;
        }else if (move == chessBoard.length * chessBoard.length){
            chessBoard[row][col] = move;
            System.out.println();
            System.out.println(Arrays.deepToString(chessBoard));
            chessBoard[row][col] = 0;
        }

        chessBoard[row][col] = move;

        printKnightsTourWhenAllCellsFill(chessBoard, row - 2, col + 1, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row - 1, col + 2, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row + 1, col + 2, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row + 2 ,col + 1, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row + 2, col - 1, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row + 1, col - 2, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row - 1, col - 2, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row - 2, col - 1, move + 1);

        chessBoard[row][col] = 0;
    }

}
