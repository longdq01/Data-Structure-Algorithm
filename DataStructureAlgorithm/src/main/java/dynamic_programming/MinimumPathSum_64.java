package dynamic_programming;

public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int col = grid[0].length, row = grid.length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = grid[i][j];
                int tmp = -1;
                if(i - 1 >= 0){
                    tmp = dp[i-1][j];
                }
                if(j - 1 >= 0){
                    if(tmp == -1){
                        tmp = dp[i][j-1];
                    }else{
                        tmp = Math.min(tmp, dp[i][j-1]);
                    }
                }
                if(tmp == -1){
                    tmp = 0;
                }
                dp[i][j] += tmp;
            }
        }
        return dp[row-1][col-1];
    }
}
