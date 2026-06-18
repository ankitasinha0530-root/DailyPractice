package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class SNQueensPlaceWithSpecificOutputFormat {

    public static void main(String[] args) {

        System.out.println(solveNQueens(4));

        System.out.println();
        System.out.println(solveNQueens(5));

        System.out.println();
        System.out.println(solveNQueens(9));

    }

    private static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Fill chessBoard with '.'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        int row = 0;
        queenSolverHelper(n, board, row, result);

        return result;
    }

    public static void queenSolverHelper(int n, char[][] board, int row, List<List<String>> result){


        if(row == board.length){

            List<String> currentSol = new ArrayList<>();

            for (char[] chars : board) { // add element of each row
                currentSol.add(new String(chars));
            }
            result.add(new ArrayList<>(currentSol));
            return;
        }

        for(int col = 0; col < board.length; col++){

            if(isSafeToPlaceQueen(n, board, row, col)){

                board[row][col] = 'Q'; // if safe Place fill Queen

                queenSolverHelper(n, board, row + 1, result);

                board[row][col] = '.'; // BackTrack
            }
        }

    }



    public static boolean isSafeToPlaceQueen(int n, char[][] board, int row, int col){

        for (int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;

    }

    public List<List<String>> solveNQueensV2(int n) {
        var output = new ArrayList<List<String>>();
        backtrack(0, n, new int[n], output);
        return output;
    }
    public void backtrack(int row, int n, int[] cols, List<List<String>> output){
        if(row == n){

            var list = new ArrayList<String>();

            for(var i = 0; i < n; i++){
                var sb = new StringBuilder();

                for(var j = 0; j < n; j++){
                    sb.append(j == cols[i] ? 'Q' : '.');
                }
                list.add(sb.toString());
            }
            output.add(list);
            return;
        }

        for(var i = 0; i < n; i++){
            if(canPlace(row, i, cols)){
                var tmp = cols[row];
                cols[row] = i;
                backtrack(row + 1, n, cols, output);
                cols[row] = tmp;
            }
        }
    }
    public boolean canPlace(int row, int col, int[] cols){
        for(var r = 0; r < row; r++){
            var c = cols[r];
            if(col == c){
                return false;
            }
            var rDiff = Math.abs(row - r);
            var cDiff = Math.abs(c - col);
            if(rDiff == cDiff){
                return false;
            }
        }
        return true;
    }

}
