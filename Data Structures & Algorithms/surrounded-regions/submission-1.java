class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0,1}, {0,-1}};

    int rows = 0;
    int cols = 0;

    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited;


    public void solve(char[][] board) {

        rows = board.length;
        cols = board[0].length;

        visited = new boolean[rows][cols];

        // Start BFS from border 'O' cells to mark all un-surrounded regions
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || r == rows - 1 || c == 0 || c == cols - 1) && board[r][c] == 'O') {
                    visited[r][c] = true;
                    board[r][c] = '#';
                    queue.offer(new int[] {r, c});
                    bfs(board);
                }
            }
        }

        // Flip remaining 'O's to 'X' and restore '#' back to 'O'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    void bfs(char[][] board) {

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i=0; i<size; i++) {

                int[] cur  = queue.poll();

                int r = cur[0], c = cur[1];

                for (int[] d : DIRS) {

                    int nr = r + d[0], nc = c + d[1];

                    if(nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;

                    if (visited[nr][nc] || board[nr][nc] != 'O') continue;

                    visited[nr][nc] = true;
                    board[nr][nc] = '#';
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
    }
}