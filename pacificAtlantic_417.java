package as;

import java.util.ArrayList;
import java.util.List;

public class pacificAtlantic_417 {
	  private static int m, n;
	  private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  
	public static List<int[]> pacificAtlantic(int[][] mrr) {
        List<int[]> ret = new ArrayList<>();
        if (mrr == null || mrr.length == 0) {
            return ret;
        }

        m = mrr.length;
        n = mrr[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(mrr,i, 0, canReachP);
            dfs(mrr,i, n - 1, canReachA);
        }
        for (int i = 0; i < n; i++) {
            dfs(mrr,0, i, canReachP);
            dfs(mrr,m - 1, i, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    ret.add(new int[]{i, j});
                }
            }
        }

        return ret;
    }

    private static void dfs(int[][] matrix,int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || matrix[r][c] > matrix[nextR][nextC]) {
                continue;
            }
            dfs(matrix,nextR, nextC, canReach);
        }
    }

    public static void main(String[] args) {
    	int[][] m = {{1,2,2,3,5},
    				 {3,2,3,4,4},
    				 {2,4,5,3,1},
    				 {6,7,1,4,5},
    				 {5,1,1,2,4}};
    	List<int[]> list = pacificAtlantic(m);
    	for (int[] is : list) {
			System.out.print(is[0]+" "+is[1]);
			System.out.println();
		}
	}
}
