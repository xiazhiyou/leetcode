package as;

import java.util.ArrayList;
import java.util.List;

public class subset_78 {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backtracking(0, tempSubset, subsets, size, nums); // ��ͬ���Ӽ���С
        }
        return subsets;
    }
    
    private static void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets, int size, int[] nums) {

        if (tempSubset.size() == size) {
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempSubset.add(nums[i]);
            backtracking(i + 1, tempSubset, subsets, size, nums);
            tempSubset.remove(tempSubset.size() - 1);
        }
    }
	public static void main(String[] args) {
		int[] num = {1,2,3};
		subsets(num);
	}
}
