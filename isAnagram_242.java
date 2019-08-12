package as;

public class isAnagram_242 {

	public static void main(String[] args) {
		String s = "anagram", t = "nsgaram";
		System.out.println(isAnagram(s,t));
	}
	public static boolean isAnagram(String s, String t) {
		
		int[] cnts = new int[26];
		for (int c : s.toCharArray()) 
			cnts[c-'a']++;
		for (int c : t.toCharArray()) 
			cnts[c-'a']--;
		for (int i : cnts) {
			if(i!=0)
				return false;
		}
	    return true;   
	}
}
