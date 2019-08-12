package as;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class getSkyline_218 {

	public static class Node{
		public boolean isUp;
		public int posi;
		public int h;
		public Node(boolean isUp, int posi, int h) {
			super();
			this.isUp = isUp;
			this.posi = posi;
			this.h = h;
		}
	}
	public static class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {

			if(o1.posi!=o2.posi)
				return o1.posi-o2.posi;
			if(o1.isUp!=o2.isUp)
				return o1.isUp?-1:1;
			return 0;
		}
		
	}
	public static List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length==0)
        	return new ArrayList<int[]>();
        if(buildings==null)
        	return null;
		
		Node[] nodes = new Node[buildings.length*2];
		for (int i = 0; i < buildings.length; i++) {
			nodes[2*i]=new Node(true,buildings[i][0],buildings[i][2]);
			nodes[2*i+1]=new Node(false,buildings[i][1],buildings[i][2]);
		}
		Arrays.sort(nodes,new NodeComparator());//°´Î»ÖÃ
		
		TreeMap<Integer,Integer> htMap = new TreeMap<>();
		TreeMap<Integer,Integer> pmMap = new TreeMap<>();
		
		for (int i = 0; i < nodes.length; i++) {
			if(nodes[i].isUp){
				if(!htMap.containsKey(nodes[i].h))
					htMap.put(nodes[i].h, 1);
				else
					htMap.put(nodes[i].h,htMap.get(nodes[i].h)+1);
			}else{
				if(htMap.containsKey(nodes[i].h)){
					if(htMap.get(nodes[i].h)==1)
						htMap.remove(nodes[i].h);
					else
						htMap.put(nodes[i].h,htMap.get(nodes[i].h)-1);
				}
			}
			if(htMap.isEmpty())
				pmMap.put(nodes[i].posi, 0);
			else
				pmMap.put(nodes[i].posi, htMap.lastKey());
		}
		
		List<int[] > res= new ArrayList<int[]>();
		int start = 0;
		int height = 0;
		for(Entry<Integer, Integer> entry : pmMap.entrySet()){
			Integer curPosition = entry.getKey();
			Integer curmaxHeight = entry.getValue();
			if(height!=curmaxHeight){
				if(height!=0 || start!=0){
					int[] newRecord = new int[2];
					newRecord[0]=start;
					newRecord[1]=height;
					res.add(newRecord);
					
				}
                start = curPosition;
				height = curmaxHeight;
			}
		}
		int[] newRecord = new int[2];
		newRecord[0]=start;
		newRecord[1]=height;
		res.add(newRecord);
		
		return res;
    }
	
	public static void main(String[] args) {
//		int[][] buildings = {{0,1,3}};
		int[][] buildings = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
		List<int[]> list = getSkyline(buildings);
		for (int i = 0; i < list.size(); i++) {
			int[] js = list.get(i);
			System.out.println(js[0]+","+js[1]);
		}
	}
}
