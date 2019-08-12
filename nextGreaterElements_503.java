package as;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElements_503 {

	public static void main(String[] args) {
		int[] nums = {1,2,1};
		int[] res =nextGreaterElements(nums);
		for (int i : res) {
			System.out.print(i+" ");
		}
	}
	public static int[] nextGreaterElements(int[] nums) {
		
		    int n = nums.length;
		    int[] next = new int[n];
		    Arrays.fill(next, -1);
		    Stack<Integer> stack = new Stack<>();
		    for (int i = 0; i < n * 2; i++) {
		       while(!stack.isEmpty() && nums[stack.peek()]<nums[i%n])
		    	   next[stack.pop()]=nums[i%n];
		       if(i<n)
		    	   stack.add(i);
		    }
		    return next;
	}
}
