package as;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum_sum {

	public static void main(String[] args) {
		int[] nums = {2, 3,7, 11, 15};
		int[] twoSum = twoSum(nums,9);
		for (int i : twoSum) {
			System.out.println(i);
		}
	}
	public static int[] twoSum(int[] nums, int target) {
        int[] copyArr = new int[nums.length];
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            copyArr[i]=nums[i];
            map.put(nums[i],i);
        }
            
        Arrays.sort(copyArr);
        int l=0;
        int r=copyArr.length-1;
        while(l<r){
            int sum=copyArr[l]+copyArr[r];
            if(sum==target){
                res[0]=map.get(copyArr[l]);
                res[1]=map.get(copyArr[r]);
            }else if(sum<target){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
