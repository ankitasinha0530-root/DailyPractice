package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TKnightsPlaceInNcells {

    public static void main(String[] args) {
        int n = 4, row = 0, col = 0;
        int[][] chess = new int[n][n];

        int n1 = 9, row1 = 0, col1 = 0;
        int[][] chess1 = new int[n1][n1];

        knightsPlaceInNcells(chess, row, col, n, new ArrayList<>());
//        knightsPlaceInNcells(chess1, row1, col1, n1, new ArrayList<>());
    }

    private static void knightsPlaceInNcells(int[][] chessBoard, int row, int col, int knights, List<String> list) {

        if (knights == 0) {
            System.out.println(list);
            System.out.println(Arrays.deepToString(chessBoard));
            System.out.println();
            return;
        }

        if(row == chessBoard.length - 1 && col == chessBoard.length){ // return coz goes out of board
            return;
        }

        if(col == chessBoard.length){ // col is out of board so go to next row and return after that as when going down of recurrsion we dont need to proceed
            knightsPlaceInNcells(chessBoard, row + 1, 0, knights, list);
            return;
        }

        if(isSafeToPlaceKnights(chessBoard, row, col)){
            chessBoard[row][col] = 1;
            list.add(row + "-" + col);
            knightsPlaceInNcells(chessBoard, row, col+1, knights - 1, list);
            list.removeLast();
            chessBoard[row][col] = 0;
        }
        knightsPlaceInNcells(chessBoard, row, col+1, knights, list); // whether safe or not we need to proceed to the next col.
    }

    private static boolean isSafeToPlaceKnights(int[][] chessBoard, int row, int col) {

        if(isValidCell(chessBoard, row - 2, col + 1)){
            if(chessBoard[row - 2][col + 1] > 0){
                return false;
            }
        }

        if(isValidCell(chessBoard, row - 1, col + 2)){
            if(chessBoard[row - 1][col + 2] > 0){
                return false;
            }
        }

        if(isValidCell(chessBoard, row - 1, col - 2)){
            if(chessBoard[row - 1][col - 2] > 0){
                return false;
            }
        }

        if(isValidCell(chessBoard, row - 2, col - 1)){
            if(chessBoard[row - 2][col - 1] > 0){
                return false;
            }
        }

        return true;
    }

    private static boolean isValidCell(int[][] chessBoard, int row, int col){

        if(row >= 0 && row < chessBoard.length && col >= 0 && col < chessBoard.length){
            return true;
        }
        return false;
    }

    private static boolean isSafeToPlaceKnightsV1(int[][] chessBoard, int row, int col) {

        int i = row - 2, j = col + 1;
        if( i >=0 && j < chessBoard.length && chessBoard[i][j] > 0){
            return false;
        }

        i = row - 1; j = col + 2;
        if( i >= 0 && j < chessBoard.length && chessBoard[i][j] > 0){
            return false;
        }

        i = row - 1; j = col - 2;
        if( i >=0 && j >= 0 && chessBoard[i][j] > 0){
            return false;
        }

        i = row - 2; j = col - 1;
        if( i >=0 && j >= 0 && chessBoard[i][j] > 0){
            return false;
        }

        return true;
    }

    private static boolean isSafeToPlaceKnightsV2(int[][] chessBoard, int row, int col) {

        for (int i = row, j = col; i >= 0 && j < chessBoard.length; i = i-2, j++) {
            if(chessBoard[i][j] > 0){
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < chessBoard.length; i--, j = j+2) {
            if(chessBoard[i][j] > 0){
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j = j-2) {
            if(chessBoard[i][j] > 0){
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i = i-2, j--) {
            if(chessBoard[i][j] > 0){
                return false;
            }
        }
        return true;
    }

}

/*
        printKnightsTourWhenAllCellsFill(chessBoard, row - 2, col + 1, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row - 1, col + 2, move + 1);
//        printKnightsTourWhenAllCellsFill(chessBoard, row + 1, col + 2, move + 1);
//        printKnightsTourWhenAllCellsFill(chessBoard, row + 2 ,col + 1, move + 1);
//        printKnightsTourWhenAllCellsFill(chessBoard, row + 2, col - 1, move + 1);
//        printKnightsTourWhenAllCellsFill(chessBoard, row + 1, col - 2, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row - 1, col - 2, move + 1);
        printKnightsTourWhenAllCellsFill(chessBoard, row - 2, col - 1, move + 1);*/
