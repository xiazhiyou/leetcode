package as;

import java.util.Arrays;
import java.util.Comparator;

public class interval_435 {
	public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) 
            return 0;
        
       Arrays.sort(intervals, new Comparator<int[]>(){
        public int compare(int [] arr1, int [] arr2){
            return arr1[1] - arr2[1];
        }
       });
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) 
                continue;
            
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
	public static void main(String[] args) {
		int[][] nums = {{1,2},{2,3},{3,4},{1,3}};
		eraseOverlapIntervals(nums);
	}

}
