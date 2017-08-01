package interview;

public class SortList148 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;
		
		ListNode L1 = sortList(head);
		ListNode L2 = sortList(slow);
		
		return merge(L1, L2);		
		
	}
	
	public ListNode merge(ListNode L1, ListNode L2) {
		ListNode ans = new ListNode(0);
		ListNode p = ans;
		
		while(L1 != null && L2 != null) {
			if(L1.val <= L2.val) {
				p.next = L1;
				L1 = L1.next;
			} else {
				p.next = L2;
				L2.next = L2;
			}
			p = p.next;
		}
		
		if(L1 != null) {
			p.next = L1;
		}
		
		if(L2 != null) {
			p.next = L2;
		}
		
		return ans.next;
	}
	
	
	
}
	/*
	public ListNode sortList1(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
        
        ListNode pre = null;
        ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null) {
            pre = slow;
            slow = slow.next;
			fast = fast.next.next;
		}
        
		pre.next = null;
        
        ListNode l1 = sortList1(head);
        ListNode l2 = sortList1(slow);
        
        return mergeTwoList1(l1, l2);
    }
/*	
	public ListNode mergeTwoList(ListNode headA, ListNode headB) {
		if(headA==null) return headB;
		if(headB==null) return headA;
		ListNode result = new ListNode(0);
		ListNode fakeResult = result;
		while(headA!=null && headB!=null) {
			if(headA.val <= headB.val) {
				fakeResult.next = headA;
				headA = headA.next;
			} else {
				fakeResult.next = headB;
				headB = headB.next;
			}
            fakeResult = fakeResult.next;
		}
		if(headA == null) {
			fakeResult.next = headB;
		} else {
			fakeResult.next = headA;
		}
		return result.next;
	}

}
*/
