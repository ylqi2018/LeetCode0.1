package LinkedList;

public class RemoveNthNodeFromEndofList19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Simple but slow
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) {
			return null;
		}
		ListNode cur = head;
		ListNode pre = head;
		for(int i=0; i<n; i++) {
			cur = cur.next;
		}
		if(cur == null) {
			return head.next;
		}
		while(cur.next != null) {
			cur = cur.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return head;
	}
	
	public ListNode removeNthFromEnd1(ListNode head, int n) {
		int current = 1;
		ListNode temp = head;
		ListNode target = head;
		while(temp.next != null) {
			current++;
			if(current > n+1) {
				target = target.next;
			}
			temp = temp.next;
		}
		if(current == n) {
			head = head.next;
		} else {
			target.next = target.next.next;
		}
		return head;
	}

}
