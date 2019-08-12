package as;

public class NumArray_303 {

    public static int[] sums;

    public NumArray_303(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public static int sumRange(int[] sums,int i, int j) {
        return sums[j + 1] - sums[i];
    }
    public static void main(String[] args) {
    	int[] nums = {-2, 0, 3, -5, 2, -1};
    	System.out.println(NumArray_303.sumRange(nums,2, 5));
	}
}
