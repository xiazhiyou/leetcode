package as;

public class twoSum_167 {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int[] res = twoSum(nums,6);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}

	private static int[] twoSum(int[] nums, int target) {
		
		int l =0;
		int h =nums.length-1;
		while(l<h){
			int sum=nums[l]+nums[h];
			if(sum==target)
				return new int[]{l+1,h+1};
			else if(sum>target)
				h--;
			else
				l++;
		}
		
		return null;
	}

}
