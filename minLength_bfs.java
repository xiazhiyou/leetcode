package as;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class minLength_bfs {
	
	public static void main(String[] args) {
		int[][] nums = {{1,1,0,1},
		                {1,0,1,0},
		                {1,1,1,1},
		                {1,0,1,1}};
		System.out.println(minPathLength(nums,3,2));
	}
	
	public static int minPathLength(int[][] grids, int tr, int tc) {
		int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	    int m = grids.length, n = grids[0].length;
	    Queue<Position> queue = new LinkedList<>();
	    queue.add(new Position(0, 0, 1));
	    while (!queue.isEmpty()) {
	        Position pos = queue.poll();
	        for (int i = 0; i < 4; i++) { 
	            Position nextPos = new Position(pos.r + next[i][0], 
	            		pos.c + next[i][1], pos.length + 1);
	            if (nextPos.r < 0 || nextPos.r >= m || nextPos.c < 0 || nextPos.c >= n) 
	            	continue;
	            if (grids[nextPos.r][nextPos.c] != 1) 
	            	continue;
	            grids[nextPos.r][nextPos.c] = 0;
	            if (nextPos.r == tr && nextPos.c == tc) 
	            	return nextPos.length;
	            queue.add(nextPos);
	        }
	    }
	    return -1;
	}
}
class Position {
    int r, c, length;
    public Position(int r, int c, int length) {
        this.r = r;
        this.c = c;
        this.length = length;
    }
}

