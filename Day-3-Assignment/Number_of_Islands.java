

class Solution {
    public static boolean isValid(int nr, int nc, int rows, int cols, boolean[][] visited, char[][] grid) {
        return (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && grid[nr][nc] == '1');
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j, n, m, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int sr, int sc, int row, int col, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited[sr][sc] = true;
        q.add(new int[]{sr, sc});

        // Only 4 directions (no diagonals in LeetCode 200)
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int i = 0; i < 4; i++) {
                int nbrRow = currRow + dr[i];
                int nbrCol = currCol + dc[i];

                if (isValid(nbrRow, nbrCol, row, col, visited, grid)) {
                    visited[nbrRow][nbrCol] = true;
                    q.add(new int[]{nbrRow, nbrCol});
                }
            }
        }
    }
}
