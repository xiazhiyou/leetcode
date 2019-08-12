package as;

import java.util.PriorityQueue;

public class kthSmallest_378 {

	public static void main(String[] args) {
		int[][] matrix = { {1,  0,  9},
				   {10, 11, 13},
				   {12, 13, 15}};
		kthSmallest(matrix ,8);
	}
	 public static int kthSmallest(int[][] matrix, int k) {
	        int m = matrix.length, n = matrix[0].length;
	        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
	        for(int j = 0; j < n; j++) 
	            pq.add(new Tuple(0, j, matrix[0][j]));
	        for(int i = 0; i < k - 1; i++) { // С���ѣ�ȥ�� k - 1 ���Ѷ�Ԫ�أ���ʱ�Ѷ�Ԫ�ؾ��ǵ� k ����
	            Tuple t = pq.poll();
	            if(t.x == m - 1) 
	                continue;
	            pq.add(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
	        }
	        return pq.poll().val;
	}
	 
	 static class Tuple implements Comparable<Tuple> {
	        int x, y, val;
	        public Tuple(int x, int y, int val) {
	            this.x = x; this.y = y; this.val = val;
	        }

	        @Override
	        public int compareTo(Tuple that) {
	            return this.val - that.val;
	        }
	    }
	  
}
