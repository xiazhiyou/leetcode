package as;

import java.util.Stack;

public class largestRectangleArea_84 {

	public static void main(String[] args) {
		int[] m = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(m));
	}

	private static int largestRectangleArea(int[] m) {
		int res=0;
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < m.length; i++) {
			while(!stack.isEmpty() && m[i]<m[stack.peek()]){
				int j = stack.pop();
				int k = stack.isEmpty()?-1:stack.peek();
				int cur = (i-k-1)*m[j];
				res = Math.max(res,cur);
			}
			stack.add(i);
		}
		while(!stack.isEmpty()){
			int j = stack.pop();
			int k = stack.isEmpty()?-1:stack.peek();
			int cur = (m.length-k-1)*m[j];
			res = Math.max(res,cur);
		}
		return res;
	}
}
