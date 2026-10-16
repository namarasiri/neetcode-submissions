class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < columns; c++) {

                if (grid[r][c] == '1') {

                  dfs(grid, r, c);
                  count++;

                }

            }

        }
        
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {

        if (r < 0 || r >=grid.length || c < 0 || c >=grid[0].length) return;

        if (grid[r][c] != '1') return;

        grid[r][c] = '0';

        dfs(grid, r -1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c -1);
        dfs(grid, r, c + 1); 
    }
}
