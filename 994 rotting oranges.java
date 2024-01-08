class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] rot = new boolean[grid.length][grid[0].length];
        return helper(grid, rot, 0);
    }

    private int helper(int[][] grid, boolean[][] rot, int time) {
        boolean madeChange = false;
        if (!freshOrangesLeft(grid)) {
            return time;
        }
        int[][] adj = {{1, -1, 0, 0}, {0, 0, 1, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // if you find a rotten orange, search adj cells
                if (grid[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        int newi = i + adj[0][k];
                        int newj = j + adj[1][k];
                        if (0 <= newi && newi < grid.length && 0 <= newj && newj < grid[0].length && grid[newi][newj] == 1) {
                            rot[newi][newj] = true;
                            madeChange = true;
                        }
                    }
                }
                
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (rot[i][j]) {
                    grid[i][j] = 2;
                }
            }
        }

        if (!madeChange) {
            return -1;
        }
        return helper(grid, rot, time + 1);
    }

    private boolean freshOrangesLeft(int[][] grid) {
        boolean freshOrangesLeft = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
