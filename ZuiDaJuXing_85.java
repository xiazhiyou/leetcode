package as;

import java.util.Stack;

public class ZuiDaJuXing_85 {

	public static void main(String[] args) {
		char[][] matrix =
			{
			  {'1','0','1','0','0'},
			  {'1','0','1','1','1'},
			  {'1','1','1','1','1'},
			  {'1','0','0','1','0'}
			};
		System.out.println(maximalRectangle(matrix));
	}

	private static int maximalRectangle(char[][] matrix) {
		
		if(matrix.length==0)
			return 0;
		int maxRec = 0;
		int[] height = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				height[j] = matrix[i][j]=='0'? 0:height[j]+1;
			}
			maxRec = Math.max(maxRec, partition(height));
		}
		
		return maxRec;
	}

	private static int partition(int[] height) {

		int res = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			while(!stack.isEmpty() && height[i] <height[stack.peek()] ){
				int j = stack.pop();
				int k = stack.isEmpty()?-1:stack.peek();
				int cur = (i-k-1)*height[j];
				res = Math.max(cur, res);
			}
			stack.add(i);
		}
		while(!stack.isEmpty()){
			int j = stack.pop();
			int k = stack.isEmpty()?-1:stack.peek();
			int cur = (height.length-k-1)*height[j];
			res = Math.max(cur, res);
		}
		
		return res;
	}
}



























