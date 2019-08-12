package as;

import java.util.Arrays;
import java.util.HashSet;

public class reverseVowels_345 {

	public static void main(String[] args) {
		String str = reverseVowels("leetcode");
		System.out.println(str);
	}

	private static String reverseVowels(String s) {

		int l=0;
		int h=s.length()-1;
		
		HashSet<Character> set = new HashSet<>(
									Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
		char[] res = new char[s.length()];
		while(l<=h){
			char lc = s.charAt(l);
			char hc = s.charAt(h);
			if(!set.contains(lc)){
				res[l++]=lc;
			}else if(!set.contains(hc)){
				res[h--]=hc;
			}else{
				res[l++]=hc;
				res[h--]=lc;
			}
			
		}
		
		return new String(res);
	}


}










