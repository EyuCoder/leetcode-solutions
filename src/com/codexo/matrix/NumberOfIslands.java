package com.codexo.matrix;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                res++;
                dfs(grid, i, j);
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
    }

    public static void main(String[] args) {
        //DFS Solution
        char[][] grid = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };

        int result = numIslands(grid);
        System.out.println(result); // 1
    }
}
