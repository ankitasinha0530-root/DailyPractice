package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SNQueensPlacementOnChessBoard {

    public static void main(String[] args) {

        int[][] chessBoard = {
                {0, 0, 0, 0, },
                {0, 0, 0, 0, },
                {0, 0, 0, 0, },
                {0, 0, 0, 0, }};

        int[][] chessBoard2 = {
                {0, 0,  },
                {0, 0,  } };

        List<List<String>> result = new ArrayList<>();
        nQueenPlacementList(chessBoard2, 0, new ArrayList<>(), result);
        System.out.println(result);

        System.out.println();
        List<List<String>> result2 = new ArrayList<>();
        nQueenPlacementList(chessBoard, 0, new ArrayList<>(), result2);
        System.out.println(result2);


        System.out.println();
        nQueenPlacement(chessBoard, 0, "");

    }

    private static void nQueenPlacementList(int[][] chessBoard, int row, List<String> current, List<List<String>> result) {

        if(row == chessBoard.length) {
            System.out.println(current);
            result.add(new ArrayList<>(current));
            System.out.println("Queens placed : " + result);
            return;
        }

        for (int col = 0; col < chessBoard.length; col++) {

            if(isItSafePlaceForTheQueen(chessBoard, row, col)) {
                chessBoard[row][col] = 1;
                    current.add(row + "-" + col);

                nQueenPlacementList(chessBoard, row + 1, current, result);

 //               current.remove(current.size() - 1); // remove while backtracking
                current.removeLast();
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
