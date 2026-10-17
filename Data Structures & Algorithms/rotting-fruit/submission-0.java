class Solution {

    public final static int [][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {

        int rows = grid.length, cols = grid[0].length, fresh =0;

        Deque<int[]> queue = new ArrayDeque<>();
        int time = 0;

        for (int r=0; r < rows; r++) {

            for (int c=0; c< cols; c++) {

                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                    
                } else if (grid[r][c] == 1) {
                    fresh++;

                }
            }

        }
        
        if (fresh == 0) return 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i =0; i < size; i++) {

                int [] cur = queue.poll();


                for (int[] d : DIRS) {

                    int nr = cur[0] + d[0], nc = cur[1] + d[1];

                    if (nr < 0 || nc < 0 || nr >=rows || nc >= cols) continue;
                    if (grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int[]{nr, nc});

                }

            }

            time++;

        }
        
        return fresh == 0 ? time : -1;
    }
}
