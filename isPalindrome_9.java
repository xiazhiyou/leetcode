package as;

public class isPalindrome_9 {

	public static void main(String[] args) {
		System.out.println(isPalindrome(10));
	}

	private static boolean isPalindrome(int num) {
		if(num<0 || num%10==0)
			return false;
		int res=0;
		while(num>res){
			res=res*10+num%10;
			num/=10;
		}
		
		return num==res || num==res/10;
	}

}
