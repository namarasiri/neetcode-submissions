class Solution {

    int rows = 0;
    int cols = 0;
    int maxArea = 0;
    int area = 0;

    public int maxAreaOfIsland(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        for (int r=0; r<rows; r++) {

            for (int c=0; c<cols;c++) {

                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }

        }

        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c) {

            if (r < 0 || c < 0 || r >= rows || c >= cols) return 0;

            // cell value updated to 2 mark as visited
            if (grid[r][c] != 1) return 0;

            grid[r][c] = 2;

            return 1 + dfs(grid, r-1, c) + dfs(grid, r+1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1);

        }
}
