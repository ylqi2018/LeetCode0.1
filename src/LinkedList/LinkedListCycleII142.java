package LinkedList;

public class LinkedListCycleII142 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {	// if the linked list has a cycle
			slow = slow.next;						// it will has no end
			fast = fast.next.next;
			if(slow == fast) {		// Fast and slow are at the meeting node
				slow = head;			// Slow begin from the start, 
				while(slow != fast) {	// and fast and slow move one step one time
					slow = slow.next;	// then they will meet at the entry node
					fast = fast.next;	// because they will move the same distance
				}
				return fast;
			}
		}
		return null;	// if their is no cycle, the linked list will have an end
	}					

}
