package as;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

	public static void main(String[] args) {
		int[] nums = {1,3,3,4,11};
		int[] twoSum = twoSum(nums,6);
		for (int i : twoSum) {
			System.out.print(i+" ");
		}
	}
	public static int[] twoSum(int[] nums, int target) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length - 1;i++){
            map.put(nums[i],i);
            if(map.get(target - nums[i+1]) != null){
                return new int[]{map.get(target - nums[i+1]),i+1};
            }
            
        }
		
		
        return new int[]{-1,-1};
    }
}
