package as;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ladderLength_127 {

	public static void main(String[] args) {
		String beginword = "hit";
		String endword = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(ladderLength(beginword,endword,wordList));
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
	    wordList.add(beginWord);
	    int N = wordList.size();
	    int start = N - 1;
	    int end = 0;
	    while (end < N && !wordList.get(end).equals(endWord)) {
	        end++;
	    }
	    if (end == N) {
	        return 0;
	    }
	    List<Integer>[] graphic = buildGraphic(wordList);
	    return getShortestPath(graphic, start, end);
	}

	private static List<Integer>[] buildGraphic(List<String> wordList) {
	    int N = wordList.size();
	    List<Integer>[] graphic = new List[N];
	    for (int i = 0; i < N; i++) {
	        graphic[i] = new ArrayList<>();
	        for (int j = 0; j < N; j++) {
	            if (isConnect(wordList.get(i), wordList.get(j))) {
	                graphic[i].add(j);
	            }
	        }
	    }
	    return graphic;
	}

	private static boolean isConnect(String s1, String s2) {
	    int diffCnt = 0;
	    for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
	        if (s1.charAt(i) != s2.charAt(i)) {
	            diffCnt++;
	        }
	    }
	    return diffCnt == 1;
	}

	private static int getShortestPath(List<Integer>[] graphic, int start, int end) {
	    Queue<Integer> queue = new LinkedList<>();
	    boolean[] marked = new boolean[graphic.length];
	    queue.add(start);
	    marked[start] = true;
	    int path = 0;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        path++;
	        while (size-- > 0) {
	            int cur = queue.poll();
	            for (int next : graphic[cur]) {
	                if (next == end) {
	                    return path+1;
	                }
	                if (marked[next]) {
	                    continue;
	                }
	                marked[next] = true;
	                queue.add(next);
	            }
	        }
	    }
	    return 0;
	}
}
