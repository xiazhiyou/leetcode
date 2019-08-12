package as;

public class validPalindrome_680 {

	public static void main(String[] args) {
		System.out.println(validPalindrome("abbc"));
	}

	private static boolean validPalindrome(String s) {

		int l=0;
		int h=s.length()-1;
		while(l<h){
			if(s.charAt(l) != s.charAt(h))
				return isPlind(s,l,h-1) || isPlind(s,l+1,h);
			l++;
			h--;
		}
		
		return true;
	}

	private static boolean isPlind(String s, int i, int j) {
		
		while(i<j){
			if(s.charAt(i++)!=s.charAt(j--))
				return false;
		}
		return true;
	}

}
