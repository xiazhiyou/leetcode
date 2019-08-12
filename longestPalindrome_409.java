package as;

public class longestPalindrome_409 {

	public static void main(String[] args) {
		String s = "abccccdd";
		System.out.println(longestPalindrome(s));
	}
	public static int longestPalindrome(String s) {
		int[] res = new int[128];
		for (char i : s.toCharArray()) 
			res[i]++;
		int max=0;
		for (int i : res) 
			max+=i/2*2;
		if(max<s.length())
			max++;
        return max;
    }
}










