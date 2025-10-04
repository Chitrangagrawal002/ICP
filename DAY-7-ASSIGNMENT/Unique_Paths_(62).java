class Solution {
    public int sol(int cr, int cc, int er, int ec, int dp[][]){
        if(cr == er -1 && cc == ec - 1) return 1;
        if(cr >= er || cc >= ec) return 0;
        if(dp[cr][cc] != 0) return dp[cr][cc];
        int right = sol(cr, cc+1, er, ec, dp);
        int down = sol(cr+1, cc, er, ec, dp);
        dp[cr][cc] = right + down;
        return right + down;
    }
    public int uniquePaths(int m, int n) {
        return sol(0, 0, m, n, new int[m][n]);
    }
}
