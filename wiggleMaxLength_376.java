package as;

public class wiggleMaxLength_376 {

	public static void main(String[] args) {
		boolean[] f = new boolean[2];
		System.out.println(f[0]);

	}
	 public int wiggleMaxLength(int[] nums) {
         if(nums==null || nums.length==0)
            return 0;
         // int up = 1,down=1;
        int[] dp = new int[nums.length];
        int current = 0;
        int pre=0;
        dp[0]=1;
         for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // up = down + 1;
                // dp[i]=dp[i-1]+1;
                current=1;
            }
            if (nums[i] < nums[i - 1]) {
                // down = up + 1;
                // dp[i]=dp[i-1]+1;
                current=-1;
            }
             
             dp[i]= current==pre? dp[i]:dp[i-1]+1;
             pre=current;
             
        }
        return dp[nums.length-1];
    }
}
