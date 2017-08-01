import interview.ListNode;

public class AddTwoNumbers2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public ListNode addTwoNumber(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		ListNode p = l1;
		ListNode q = l2;
		int carry = 0;
		int sum = 0;
		
		while(p!=null && q!=null) {
			int x = (p!=null) ? p.val : 0;
			int y = (q!=null) ? q.val : 0;
			sum = x + y + carry;
			carry = sum/10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if(p!=null) p = p.next;
			if(q!=null) q = q.next;
		}
		if(carry>0) {
			curr.next = new ListNode(carry);
		}
		return head.next;
	}
	
	
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;
        
        while(p != null || q != null) {
        	int x = (p != null) ? p.val : 0;
        	int y = (q != null) ? q.val : 0;
        	int sum = carry + x + y;
        	// update carry
        	carry = sum / 10;
        	curr.next = new ListNode(sum % 10);
        	curr = curr.next;
        	if(p != null) p = p.next;
        	if(q != null) q = q.next;
        }
        if(carry > 0) {
        	curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
