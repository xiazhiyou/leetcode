package as;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class reconstructQueue_406 {
	public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) 
           return new int[0][0];
       
       //°´ÕÕÉí¸ß½µÐò KÉýÐòÅÅÐò 
        //Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
       Arrays.sort(people, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
           }
       });
       List<int[]> queue = new ArrayList<>();
       for (int[] p : people) 
           queue.add(p[1], p);
      
       return (int[][]) queue.toArray();
   }
	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		people = reconstructQueue(people);
	}

}
