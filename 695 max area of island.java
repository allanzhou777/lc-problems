class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0; 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int temp = helper(grid, i, j);
                    maxArea = Math.max(temp, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int helper(int[][] grid, int i, int j) {
        if (!(0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == 1)) {
            return 0;
        }
        grid[i][j] = 0;
        return helper(grid, i + 1, j) + helper(grid, i, j + 1) + helper(grid, i - 1, j) + helper(grid, i, j - 1) + 1;
    }
}