package as;

import java.util.Arrays;
import java.util.Comparator;

public class findLongestChain_646 {

	public class ascComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
		
	}
	public static void main(String[] args) {
		int[][] nums = {{6,7},{4,5},{3,4}};
		System.out.println(findLongestChain(nums));
	}

	private static int findLongestChain(int[][] pairs) {

		if (pairs == null || pairs.length == 0) {
	        return 0;
	    }
		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
//		Arrays.sort(pairs);
	    int n = pairs.length;
	    int[] dp = new int[n];
	    Arrays.fill(dp, 1);
	    for (int i = 1; i < n; i++) {
	        for (int j = 0; j < i; j++) {
	            if (pairs[j][1] < pairs[i][0]) {
	                dp[i] = Math.max(dp[i], dp[j] + 1);
	            }
	        }
	    }
	    return Arrays.stream(dp).max().orElse(0);
		
	}

}
