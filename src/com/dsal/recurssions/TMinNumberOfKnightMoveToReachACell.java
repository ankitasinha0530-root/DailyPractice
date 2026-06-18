package com.dsal.recurssions;


import java.util.ArrayDeque;
import java.util.Deque;

public class TMinNumberOfKnightMoveToReachACell {

    // Whenever we need to find minimum better to use breadth first search
    // and always use deque

    public static void main(String[] args) {

        System.out.println(minNumberOfKnightMoveToReachACell(5, 5));

        System.out.println(minNumberOfKnightMoveToReachACell(9, 9));

    }

    private static int minNumberOfKnightMoveToReachACell(int tRow, int tCol) {

       int[][] directions = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}, {-2, -1}, {-1, -2}};

       boolean[][] visited = new boolean[607][607];

        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0});

        int x = 0;
        int y = 0;
        int minStep = 0;

        while (!queue.isEmpty()){ // while queue is not empty

            int levelSize = queue.size(); // calculate the size of queue and store

            for (int i = 0; i < levelSize; i++) { // loop through the size of queue

                int[] current = queue.removeFirst(); // extract element from start

                if(tRow == current[0] && tCol == current[1]){ // check if coordinates matched
                    return minStep;                         // if yes then return minStep.
                }

                for (int[] dir : directions) { // check for each offset direction

                    int dx = current[0] + dir[0];
                    int dy = current[1] + dir[1];

                    if (!visited[dx + 302][dy + 302]) {
                        visited[dx + 302][dy + 302] = true;
                        queue.addLast(new int[]{dx, dy}); // add to teh last of Queue
                    }
                }
            }
            minStep++;
        }
        return minStep;
    }
}


