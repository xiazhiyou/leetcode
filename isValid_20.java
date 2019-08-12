package as;

import java.util.Stack;

public class isValid_20 {

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}

	private static boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if(c=='(' )
				stack.add(')');
			else if(c=='[' )
				stack.add(']');
			else if(c=='{' )
				stack.add('}');
			else{
				if(stack.isEmpty() || stack.pop()!=c)
					return false;
			}
		}
		
		return stack.isEmpty();
	}

}
