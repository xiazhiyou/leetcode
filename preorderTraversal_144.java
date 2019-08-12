package as;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal_144 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.left = new Node(2);
		head1.right = new Node(3);
		head1.left.left = new Node(4);
		head1.left.right= new Node(5);
		List<Integer> list = posorderTraversal2(head1);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}

	private static List<Integer> posorderTraversal2(Node head) {
		List<Integer> list = new ArrayList();
		 if(head==null){
			 return list;
		 }
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(head);
		while (!s1.isEmpty()) {
			head = s1.pop();
			s2.push(head);
			if (head.left != null) 
				s1.add(head.left);
			if (head.right != null) 
				s1.add(head.right);
		}
		while (!s2.isEmpty()) 
			list.add(s2.pop().value);
		return list;
	}

	private static List<Integer> posorderTraversal1(Node head1) {
		List<Integer> list = new ArrayList();
        if(head1==null){
            return list;
        }
        return partition11(head1, list);
	}

	private static List<Integer> partition11(Node root, List<Integer> list) {
		
        if(root.left!=null){
            partition11(root.left, list);
        }
     
        if(root.right!=null){
            partition11(root.right, list);
        }
        list.add(root.value);
        return list;
		
	}

	private static List<Integer> midorderTraversal2(Node head1) {

		List<Integer> list = new ArrayList();
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || head1!=null){
			if(head1!=null){
				stack.add(head1);
				head1=head1.left;
			}else{
				head1 = stack.pop();
				list.add(head1.value);
				head1=head1.right;
			}
		}
		return list;
	}

	private static List<Integer> midorderTraversal1(Node head1) {
		List<Integer> list = new ArrayList();
        if(head1==null){
            return list;
        }
        return partition1(head1, list);
	}

	private static List<Integer> partition1(Node root, List<Integer> list) {
		
        if(root.left!=null){
            partition1(root.left, list);
        }
        list.add(root.value);
        if(root.right!=null){
            partition1(root.right, list);
        }
        return list;
		
	}

	private static List<Integer> preorderTraversal2(Node head1) {
		List<Integer> list = new ArrayList();
		Stack<Node> stack = new Stack<Node>();
		stack.add(head1);
		while(!stack.isEmpty()){
			Node pop = stack.pop();
			list.add(pop.value);
			if(pop.right!=null)
				stack.add(pop.right);
			if(pop.left!=null)
				stack.add(pop.left);
		}
		
		return list;
	}

	private static List<Integer> preorderTraversal1(Node head1) {
		List<Integer> list = new ArrayList();
        if(head1==null){
            return list;
        }
        return partition(head1, list);
	}

	private static List<Integer> partition(Node root, List<Integer> list) {
		
		list.add(root.value);
        if(root.left!=null){
            partition(root.left, list);
        }
        if(root.right!=null){
            partition(root.right, list);
        }
        return list;
		
	}
}
