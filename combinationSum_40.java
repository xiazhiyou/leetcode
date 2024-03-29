package as;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum_40 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    List<List<Integer>> combinations = new ArrayList<>();
	    Arrays.sort(candidates);
	    backtracking(new ArrayList<>(), combinations, new boolean[candidates.length], 0, target, candidates);
	    return combinations;
	}

	private static void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations,
	                          boolean[] hasVisited, int start, int target, final int[] candidates) {

	    if (target == 0) {
	        combinations.add(new ArrayList<>(tempCombination));
	        return;
	    }
	    for (int i = start; i < candidates.length; i++) {
	        if (i != 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]) {
	            continue;
	        }
	        if (candidates[i] <= target) {
	            tempCombination.add(candidates[i]);
	            hasVisited[i] = true;
	            backtracking(tempCombination, combinations, hasVisited, i + 1, target - candidates[i], candidates);
	            hasVisited[i] = false;
	            tempCombination.remove(tempCombination.size() - 1);
	        }
	    }
	}
	public static void main(String[] args) {
		int[] nums = {2,2,2};
		combinationSum2(nums,2);
	}

}
