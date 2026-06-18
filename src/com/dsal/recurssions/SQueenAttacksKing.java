package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQueenAttacksKing {

    public static void main(String[] args) {
        
        int[][] queens = {{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};

        System.out.println(queensAttacktheKing(queens, new int[]{3, 3}));
        System.out.println();
        System.out.println(queensAttacktheKingV2(queens, new int[]{3, 3}));
    }

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        List<List<Integer>> result = new ArrayList<>();

        boolean[][] seen = new boolean[8][8];

        for (int[] queen : queens){
            seen[queen[0]][queen[1]] = true;
        }

        System.out.println(Arrays.deepToString(seen));

        int[] directions = {-1, 0, 1};

        for (int dx : directions){     // -1, -1, -1 , 0, 0,        0,  1, 1, 1
            for (int dy : directions){ // -1,  0,  1, -1, 0(skip),  1, -1, 0, 1

                if(dx == 0 && dy == 0){ // ignore this as there will no impact on x and y, hence, skip
                    continue;
                }
                int x = king[0];
                int y = king[1];

                while(x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8){
                    x += dx;
                    y += dy;
                    if(seen[x][y]){
                        result.add(List.of(x, y));
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> queensAttacktheKingV2(int[][] queens, int[] king) {

        List<List<Integer>> result = new ArrayList<>();

        boolean[][] seen = new boolean[8][8];

        for (int[] queen : queens){
            seen[queen[0]][queen[1]] = true;
        }

        System.out.println(Arrays.deepToString(seen));

        int row = king[0];
        int col = king[1];

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(seen[i][j]){
                result.add(List.of(i, j));
                break;
            }
        }

        for (int i = row - 1; i >= 0 ; i--) {
            if(seen[i][col]){
                result.add(List.of(i, col));
                break;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++) {
            if(seen[i][j]){
                result.add(List.of(i, j));
                break;
            }
        }

        for (int j = col + 1; j < 8 ; j++) {
            if(seen[row][j]){
                result.add(List.of(row, j));
                break;
            }
        }

        for (int i = row + 1, j = col + 1; i < 8 && j < 8; i++, j++) {
            if(seen[i][j]){
                result.add(List.of(i, j));
                break;
            }
        }

        for (int i = row + 1; i < 8; i++) {
            if(seen[i][col]){
                result.add(List.of(i, col));
                break;
            }
        }

        for (int i = row + 1, j = col - 1; i < 8 && j >= 0; i++, j--) {
            if(seen[i][j]){
                result.add(List.of(i, j));
                break;
            }
        }

        for (int j = col - 1; j >= 0 ; j--) {
            if(seen[row][j]){
                result.add(List.of(row, j));
                break;
            }
        }

        return result;
    }
}


