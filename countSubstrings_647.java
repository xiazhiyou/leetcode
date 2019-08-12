package as;

public class countSubstrings_647 {
	static int cnt = 0;
	public static void main(String[] args) {
		String s = "aaa";
		System.out.println(countSubstrings(s));
	}
	public static int countSubstrings(String s){
		
		for (int i = 0; i < s.length(); i++) {
			extendSubString(s,i,i);
			extendSubString(s,i,i+1);
		}
		return cnt;
	}
	private static void extendSubString(String s, int start, int end) {

		while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
				start--;
				end++;
				cnt++;
		}
	}
}
