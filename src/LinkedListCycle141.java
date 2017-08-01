import java.util.HashSet;
import java.util.Set;

import interview.ListNode;

public class LinkedListCycle141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasCycle(ListNode head) {
		Set<ListNode> nodesSeen = new HashSet<ListNode>();
		while(head != null) {
			if(nodesSeen.contains(head)) {
				return true;
			} else {
				nodesSeen.add(head);
			}
			head = head.next;
		}
		return false;
	}
	
	public boolean hasCycle1(ListNode head) {
		if(head==null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(slow != fast) {
			if(fast==null || fast.next==null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

}
