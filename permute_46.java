package as;

import java.util.ArrayList;
import java.util.List;

public class permute_46 {
	 public static List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        List<Integer> value = new ArrayList<>();
	        boolean[] hasVisited = new boolean[nums.length];
	        backtracking(value,res,hasVisited, nums);
	        return res;
	    }
	    private static void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited, int[] nums) {
	        if (permuteList.size() == nums.length) {
	            permutes.add(new ArrayList<>(permuteList)); // 重新构造一个 List
	            return;
	        }
	        for (int i = 0; i < visited.length; i++) {
	            if (visited[i]) 
	                continue;
	            
	            visited[i] = true;
	            permuteList.add(nums[i]);   //添加
	            backtracking(permuteList, permutes,visited, nums);
	            permuteList.remove(permuteList.size() - 1);   //删除
	            visited[i] = false;
	        }
	    }
	public static void main(String[] args) {
		int[] num = {1,2,3};
		List<List<Integer>> list = permute(num);
		System.out.println(list);
	}

}
