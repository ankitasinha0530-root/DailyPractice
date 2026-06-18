package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class QFloodFill {

//    static List<String> result = new ArrayList<>();
//
//    static List<String> result2 = new ArrayList<>();

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0}   };

        int[][] maze = 	 {
                {0, 1, 0, 0, },
                {0, 1, 0, 1, },
                {0, 0, 0, 0, },
                {0, 0, 1, 0, },
                {0, 0, 0, 0, }  };

        boolean[][] visitedMatrix = new boolean[matrix.length][matrix[0].length];

        List<String> result = new ArrayList<>();
        floodFill(matrix, 0, 0, visitedMatrix, "", result);
        System.out.println(result);

        boolean[][] visitedMaze = new boolean[maze.length][maze[0].length];
        List<String> result2 = new ArrayList<>();
        floodFill(maze, 0, 0, visitedMaze, "", result2);
        System.out.println(result2);

    }

    private static void floodFill(int[][] matrix, int row, int col, boolean[][] visited, String ans, List<String> result) {

        if(row < 0 || col < 0 || row == matrix.length || col == matrix[0].length || matrix[row][col] == 1 || visited[row][col]){
            return;
        }

        if(row == matrix.length - 1  && col == matrix[0].length - 1){
            System.out.println("ans : " + ans);
            result.add(ans);
            return;
        }

        visited[row][col] = true;

        floodFill(matrix, row-1, col, visited, ans + "t", result);
        floodFill(matrix, row, col-1, visited, ans + "l", result);
        floodFill(matrix, row+1, col, visited, ans + "d", result);
        floodFill(matrix, row, col+1, visited, ans + "r", result);

        visited[row][col] = false;

    }
}
