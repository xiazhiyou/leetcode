package as;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findLongestWord_524 {

	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> d = new ArrayList<String>(Arrays.asList("ale","apple","monkey","plea"));
		String res = findLongestWord(s,d);
		System.out.println(res);
	}

	private static String findLongestWord(String s, List<String> d) {
		
		String res = "";
		for (String target : d) {
			int l1=res.length();
			int l2=target.length();
			if(l1>l2 || (l1==l2)&&res.compareTo(target)<0)
				continue;
			if(isValid(s,target))
				res=target;
		}
		return res;
	}

	private static boolean isValid(String s, String target) {

		int i=0,j=0;
		while(i<s.length() && j<target.length()){
			if(s.charAt(i)==target.charAt(j))
				j++;
			i++;
		}
		
		return j==target.length();
	}

}
