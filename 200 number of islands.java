class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        // if you encounter a 1, increment count
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j) {
        // if you encounter a 1, make every adjacent 1 a 0
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length) {
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
                helper(grid, i + 1, j);
                helper(grid, i, j + 1);
                helper(grid, i - 1, j);
                helper(grid, i, j - 1);
            }
        }
    }
}