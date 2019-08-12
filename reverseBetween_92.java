package as;

import java.util.ArrayList;
import java.util.List;

public class reverseBetween_92 {

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		reverseBetween(head,2,4);
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode mNode = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = mNode.next;
            mNode.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return res.next;
    }
}
	
