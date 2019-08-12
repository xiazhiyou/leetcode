package as;

public class uniquePathsWithObstacles_63 {

	public static void main(String[] args) {
		int[][] nums = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(nums));
	}
	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	       int m = obstacleGrid.length, n = obstacleGrid[0].length;
	       int[] dp = new int[n];
	       // Arrays.fill(dp, 1);
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if(obstacleGrid[i][j]==1)
	                    dp[j]=0;
	                else{
	                     if (j == 0) {
	                        dp[j] =1;        // 只能从上侧走到该位置
	                    } else if (i == 0) {
	                        dp[j] = dp[j - 1];    // 只能从左侧走到该位置
	                    } else {
	                        dp[j] = dp[j - 1]+dp[j];
	                    }
	                }
	                    
	            }
	        }
	        return dp[n - 1]; 
	    }
}
