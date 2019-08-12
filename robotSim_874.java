package as;

import java.util.HashMap;
import java.util.Map;

public class robotSim_874 {
	public static void main(String[] args) {
		int[] commands = {4,-1,4,-2,4};
		int[][] obstacles = {{2,4}};
		System.out.println(robotSim(commands,obstacles));
	}

	private static int robotSim(int[] commands, int[][] obstacles) {

		int max = 0;
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < obstacles.length; i++) {
			map.put(obstacles[i][0]+","+obstacles[i][1], true);
		}
		int row=0;
		int col=0;
		int k = 0;
		int[][] dk = {{0,1},{1,0},{0,-1},{-1,0}};
		for (int command : commands) {
			if(command==-1){
				k=(k+1)%4;
			}else if(command==-2){
				k=(k+3)%4;
			}else{
				int[] cur = dk[k];
				for (int i = 0; i < command; i++) {
					if(map.containsKey((row+cur[0])+","+(col+cur[1])))
						break;
					row+=cur[0];
					col+=cur[1];
				}
				max = Math.max(max, row*row+col*col);
			}
		}
        return max;
	}
}
