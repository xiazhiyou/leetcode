package as;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class test1 {

	public static void main(String[] args) {
		reverseVowels("hello");
	}
	 public static String reverseVowels(String s) {
	        List<Character> list = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
	        int i=0;
	        int j=s.length()-1;
	        char[] res = new char[s.length()];
	        
	        while(i<j){
	            char ci = s.charAt(i);
	            char cj = s.charAt(j);
	            if(!list.contains(ci))
	                res[i++]=ci;
	            if(!list.contains(cj))
	                res[j--]=cj;
	            else{
	                res[i++] = cj;
	                res[j--] = ci;
	            }
	        }
	        return new String(res);
	    }

}
