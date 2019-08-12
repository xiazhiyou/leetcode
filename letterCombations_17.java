package as;

import java.util.ArrayList;
import java.util.List;

public class letterCombations_17 {
	private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public static List<String> letterCombinations(String digits) {
		
	    List<String> combinations = new ArrayList<>();
	    if (digits == null || digits.length() == 0) {
	        return combinations;
	    }
	    StringBuilder ab = new StringBuilder();
	    doCombination(ab, combinations, digits);
	    return combinations;
	}

	private static void doCombination(StringBuilder prefix, List<String> combinations,String digits) {
	    if (prefix.length() == digits.length()) {
	        combinations.add(prefix.toString());
	        return;
	    }
	    int curDigits = digits.charAt(prefix.length()) - '0';
	    String letters = KEYS[curDigits];
	    for (char c : letters.toCharArray()) {
	        prefix.append(c);                         // ���
	        doCombination(prefix, combinations, digits);
	        prefix.deleteCharAt(prefix.length() - 1); // ɾ��
	    }
	}
	public static void main(String[] args) {
		String s = "23";
		List<String> list = letterCombinations(s);
		for (String string : list) {
			System.out.print(string+" ");
		}
	}

}
