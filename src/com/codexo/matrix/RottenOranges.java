package com.codexo.matrix;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges
public class RottenOranges {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int total = 0, rotten = 0, time = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) total++;
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        if (total == 0) return 0;

        while (!q.isEmpty() && rotten < total) {
            int size = q.size();

            rotten += size;
            if (rotten == total) return time;

            time++;

            for (int i = 0; i < size; i++) {
                int[] p = q.poll();

                assert p != null;
                if (p[0] + 1 < grid.length && grid[p[0] + 1][p[1]] == 1) {
                    grid[p[0] + 1][p[1]] = 2;
                    q.offer(new int[]{p[0] + 1, p[1]});
                }
                if (p[0] - 1 >= 0 && grid[p[0] - 1][p[1]] == 1) {
                    grid[p[0] - 1][p[1]] = 2;
                    q.offer(new int[]{p[0] - 1, p[1]});
                }
                if (p[1] + 1 < grid[0].length && grid[p[0]][p[1] + 1] == 1) {
                    grid[p[0]][p[1] + 1] = 2;
                    q.offer(new int[]{p[0], p[1] + 1});
                }
                if (p[1] - 1 >= 0 && grid[p[0]][p[1] - 1] == 1) {
                    grid[p[0]][p[1] - 1] = 2;
                    q.offer(new int[]{p[0], p[1] - 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        //BFS Solution
        int[][] grid = new int[][]{
                new int[]{2, 1, 1},
                new int[]{1, 1, 0},
                new int[]{0, 1, 1}
        };

        int result = orangesRotting(grid);
        System.out.println(result); // 4
    }
}
