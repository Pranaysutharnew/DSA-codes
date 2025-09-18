package Recursion.Medium;

public class Leetcode_1219 {
//    Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
//    Output: 24
//    Explanation:
//            [[0,6,0],
//            [5,8,7],
//            [0,9,0]]
//    Path to get the maximum gold, 9 -> 8 -> 7.
//    Example 2:
//
//    Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//    Output: 28
//    Explanation:
//            [[1,0,7],
//            [2,0,6],
//            [3,4,5],
//            [0,3,0],
//            [9,0,20]]
//    Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumGold(grid));
        System.out.println(getMaximumGold1(grid));
    }
    static int rows , cols;
    static int[][] dir = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
    public static int getMaximumGold(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        int maxGold = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0){
                    maxGold = Math.max(maxGold, depthForSearch(i, j, grid, isVisited));
                }
            }
        }
        return maxGold;
    }

    private static int depthForSearch(int row, int col, int[][] grid, boolean[][] isVisited){
        // base cases of row and col out of bound
        if (row < 0 || row >= rows || col < 0 || col >= cols){
            return 0;
        }
        // base case for gris[row][col] = 0 or isVisited = true;
        if (grid[row][col] == 0 || isVisited[row][col]){
            return 0;
        }

        isVisited[row][col] = true;
        int maxGold = 0;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            maxGold = Math.max(maxGold, depthForSearch(newRow, newCol, grid, isVisited));
        }

        isVisited[row][col] = false;

        return grid[row][col] + maxGold;
    }

//    // same code with pruning
//    static int rows , cols;
//    static int[][] dir = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
    public static int getMaximumGold1(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        int totalGold = 0;
        int maxGold = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalGold += grid[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0){
                    maxGold = Math.max(maxGold, depthForSearch1(i, j, grid));

                    if (maxGold == totalGold){
                        return maxGold;
                    }
                }
            }
        }
        return maxGold;
    }

    private static int depthForSearch1(int row, int col, int[][] grid){
        // base cases of row and col out of bound
        if (row < 0 || row >= rows || col < 0 || col >= cols){
            return 0;
        }
        // base case for gris[row][col] = 0 or isVisited = true;
        if (grid[row][col] == 0 || grid[row][col] == -1){
            return 0;
        }

        int temp = grid[row][col];
        grid[row][col] = -1;
        int maxGold = 0;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            maxGold = Math.max(maxGold, depthForSearch1(newRow, newCol, grid));
        }

        grid[row][col] = temp;

        return temp + maxGold;
    }
}
