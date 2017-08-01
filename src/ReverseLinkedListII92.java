import interview.ListNode;

public class ReverseLinkedListII92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null) {
			return null;
		}
		
		// create a dummy node to mark the head of this list
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		// make a pointer pre as a marker for the node before reversing
		ListNode pre = dummy;
		for(int i=0; i<m-1; i++) {
			pre = pre.next;
		}	// pre will stop at m-1
		
		// a pointer to the beginning of a sub-list that will be reversing
		ListNode start = pre.next;
		// a pointer to a node that will be reversed
		ListNode then = start.next;
		
		for(int i=0; i<n-m; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}
		
		return dummy.next;
		
	}

}
