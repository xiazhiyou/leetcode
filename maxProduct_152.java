package as;

public class maxProduct_152 {
	public static void main(String[] args) {
		int[] m = {-2,3,-4};
		System.out.println(maxProduct(m));
	}

	private static int maxProduct(int[] arr) {

		int max = arr[0];
		int min = arr[0];
		int res = arr[0];
		
		int maxEnd = 0;
		int minEnd = 0;
		for (int i = 1; i < arr.length; i++) {
			maxEnd = max*arr[i];
			minEnd = min*arr[i];
			
			max=Math.max(Math.max(maxEnd, minEnd), arr[i]);
			min=Math.min(Math.min(maxEnd, minEnd), arr[i]);
			
			res = Math.max(max, res);
		}
		
		return res;
	}
}
