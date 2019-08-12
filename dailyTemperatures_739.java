package as;

import java.util.Stack;

public class dailyTemperatures_739 {

	public static void main(String[] args) {

		int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] temperatures = dailyTemperatures(nums);
		for (int i : temperatures) {
			System.out.print(i+" ");
		}
		
	}
	public static int[] dailyTemperatures(int[] nums) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
				int preindex = stack.pop();
				int cur = i-preindex;
				res[preindex]=cur;
			}
			stack.add(i);
		}
		
        return res;
    }
}
