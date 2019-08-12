package as;

public class countBinarySubstrings_696 {

	public static void main(String[] args) {
		String s = "00110011";
		System.out.println(countBinarySubstrings(s));
	}

	private static int countBinarySubstrings(String s) {
		int count=0;
		int prelen=0;
		int curlen=1;
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)==s.charAt(i-1))
				curlen++;
			else{
				prelen=curlen;
				curlen=1;
			}
			if(prelen>=curlen)
				count++;
		}
		
		return count;
	}

}
