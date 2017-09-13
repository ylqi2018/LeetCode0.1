package LinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode B = new ListNode(2);
		ListNode C = new ListNode(3);
		head.next = B;
		B.next = C;
		ReverseLinkedList rl = new ReverseLinkedList();
		rl.reverseList1(head);
		
	}

	// Iterative
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
        	ListNode next = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = next;
        }
        return prev;
    }
    
    // Recursive
    public ListNode reverseList1(ListNode head) {
    	if(head==null || head.next==null) return head;
    	ListNode p = reverseList1(head.next);
    	head.next.next = head;
    	head.next = null;
    	return p;
    }

}
