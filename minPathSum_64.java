package as;

public class minPathSum_64 {

	public static void main(String[] args) {

		int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(nums));
	}
	  public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j];        // ֻ�ܴ��ϲ��ߵ���λ��
                } else if (i == 0) {
                    dp[j] = dp[j - 1];    // ֻ�ܴ�����ߵ���λ��
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
	 }
}
