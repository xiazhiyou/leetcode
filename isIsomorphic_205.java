package as;

public class isIsomorphic_205 {

	public static void main(String[] args) {
		String s = "aba", t = "baa";
		System.out.println(isIsomorphic(s,t));
	}
	public static boolean isIsomorphic(String s, String t) {
		
		int[] res1 = new int[128];
		int[] res2 = new int[128];
		
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if(res1[sc]!=res2[tc])
				return false;
			res1[sc]=i+1;
			res2[tc]=i+1;
		}
		
        return true;
    }
}
