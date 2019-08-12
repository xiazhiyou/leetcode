package as;

public class isPalindrome_234 {
	
	public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode pre = null;
        ListNode next = null;
        while(slow!=null){
            next = slow.next;
            slow.next=pre;
            pre=slow;
            slow=next;
        }
        slow=pre;
        fast=head;
        while(slow!=null){
            if(slow.val!=fast.val)
                return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(head));;
	}
}

