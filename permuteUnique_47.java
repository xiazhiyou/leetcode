package as;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique_47 {
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        Arrays.sort(nums);  // ÅÅĞò
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList, permutes, hasVisited, nums);
        return permutes;
    }

    private static void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited, final int[] nums)     {
        if (permuteList.size() == nums.length) {
            permutes.add(new ArrayList<>(permuteList));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;  // ·ÀÖ¹ÖØ¸´
            }
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList, permutes, visited, nums);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
	public static void main(String[] args) {
		int[] num = {1,1,2};
		permuteUnique(num);
		
	}

}
