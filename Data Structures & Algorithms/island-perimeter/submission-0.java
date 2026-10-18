class Solution {
    int rows = 0, cols = 0;
    boolean [][] visited;

    public int islandPerimeter(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int r=0; r < rows; r++) {

            for (int c=0; c < cols; c++) {

                if (grid[r][c] == 1) {
                    return dfc(grid, r, c);
                }

            }

        }
        
        return 0;
    }

    public int dfc (int[][] grid, int r, int c) {

        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) return 1;

        if (visited[r][c]) return 0;

        visited[r][c] = true;

        return dfc (grid, r-1, c) + dfc (grid, r+1,c) + dfc (grid,r,c-1) +dfc (grid,r,c+1);

    }
}