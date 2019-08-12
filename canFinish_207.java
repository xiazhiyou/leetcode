package as;

import java.util.ArrayList;
import java.util.List;

public class canFinish_207 {

	public static void main(String[] args) {
		int[][] nums = {{1,0},{0,1}};
		System.out.println(canFinish(2,nums));
	}
	
	public static boolean canFinish(int num, int[][] prerequisites) {
		
		List<Integer>[] graphic = new ArrayList[num];
		for (int i = 0; i < graphic.length; i++) {
			graphic[i] = new ArrayList<Integer>();
		}
		
		for (int[] pre : prerequisites) {
			graphic[pre[0]].add(pre[1]);
		}
	    boolean[] globalMarked = new boolean[num];
	    boolean[] localMarked = new boolean[num];
	    for (int i = 0; i < num; i++) {
	        if (hasCycle(globalMarked, localMarked, graphic, i)) {
	            return false;
	        }
	    }
	  return true;
    }

	private static boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, List<Integer>[] graphic, int curNode) {
		if (localMarked[curNode]) {
	        return true;
	    }
	    if (globalMarked[curNode]) {
	        return false;
	    }
	    globalMarked[curNode] = true;
	    localMarked[curNode] = true;
	    for (int nextNode : graphic[curNode]) {
	        if (hasCycle(globalMarked, localMarked, graphic, nextNode)) {
	            return true;
	        }
	    }
	    localMarked[curNode] = false;
	    return false;
	}
}
