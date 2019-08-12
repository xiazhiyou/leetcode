package as;

import java.util.Stack;

public class minStack {
	    Stack<Integer> dataStack = new Stack<>();
	    Stack<Integer> minStack = new Stack<>();
	    public void push(int node) {
	        dataStack.push(node);
	        if(minStack.isEmpty() ||node<minStack.peek())
	            minStack.push(node);
	        else
	            minStack.push(minStack.peek());
	    }
	    
	    public void pop() {
	        if(dataStack.isEmpty())
	            return;
	        dataStack.pop();
	        minStack.pop();
	    }
	    
	    public int top() {
	        if(dataStack.isEmpty())
	            return -1;
	        return dataStack.peek();
	    }
	    
	    public int min() {
	        if(minStack.isEmpty())
	            return -1;
	        return minStack.peek();
	    }
	public static void main(String[] args) {
	 minStack m = new minStack();
	 m.push(1);
	 m.push(0);

	}

}
