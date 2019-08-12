package as;

public class judgeSquareSum_633 {

	public static void main(String[] args) {

		System.out.println(judgeSquareSum(4));
	}

	private static boolean judgeSquareSum(int i) {

		int l=0;
		int h=(int) Math.sqrt(i);
		while(l<=h){
			int sum = l*l+h*h;
			if(sum==i)
				return true;
			else if(sum>i)
				h--;
			else
				l++;
		}
		
		return false;
	}

}
