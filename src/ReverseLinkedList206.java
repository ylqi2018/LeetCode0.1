import interview.ListNode;

public class ReverseLinkedList206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		ListNode nextTemp = null;
		while(curr != null) {
			nextTemp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = nextTemp;
		}
		return pre;
	}
	
	public ListNode reverseList1(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode p = reverseList1(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

}
