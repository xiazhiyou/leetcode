package as;

public class numberOfArithmeticSlices_413 {

	public static void main(String[] args) {
		int[] nums = {1,3,5,7,9};
		System.out.println(numberOfArithmeticSlices(nums));
	}
	public static int numberOfArithmeticSlices(int[] nums) {
		 if (nums == null || nums.length == 0) {
		        return 0;
		 }
		int[] dp=new int[nums.length];
		for (int i = 2; i < nums.length; i++) {
			if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2])
				dp[i]=dp[i-1]+1;
		}
		int total=0;
		for (int i : dp) {
			total+=i;
		}
		
        return total;
    }
}
