package LinkedList;

<<<<<<< HEAD
import interview.ListNode;

=======
>>>>>>> a5dc90b9f368f271b1982c8efd1f72b2329a8167
public class AddTwoNumbers2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
<<<<<<< HEAD
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Add from the LSB
    	ListNode dummy = new ListNode(-1);
    	ListNode curr = dummy;
    	int carry = 0;
    	int d1 = 0;
    	int d2 = 0;
    	int sum = 0;
    	while(l1 != null || l2 != null) {	// As long as there still have nodes in l1 or l2
    		d1 = l1 == null? 0 : l1.val;
    		d2 = l2 == null? 0 : l2.val;
    		sum = d1 + d2 + carry;
    		carry = sum >= 10 ? 1 : 0;
    		curr.next = new ListNode(sum%10);
    		curr = curr.next;
    		if(l1 != null) l1 = l1.next;
    		if(l2 != null) l2 = l2.next;    		
    	}
    	if(carry == 1) {
    		curr.next = new ListNode(1);
    	}
    	return dummy.next;
    }
    
}

/*
=======
>>>>>>> a5dc90b9f368f271b1982c8efd1f72b2329a8167

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }
    
<<<<<<< HEAD
    
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode head = new ListNode(0);
//         ListNode curr = head;
//         ListNode p = l1;
//         ListNode q = l2;
        
//         int carry = 0;
//         int sum = 0;
//         int x = 0;
//         int y = 0;
        
//         while(p!=null || q!=null) {
//             x = (p!=null) ? p.val : 0;
//             y = (q!=null) ? q.val : 0;
//             sum = x + y + carry;
//             carry = sum / 10;
//             curr.next = new ListNode(sum%10);
//             curr = curr.next;
            
//             if(p!=null) p = p.next;
//             if(q!=null) q = q.next;
//         }
//         if(carry>0) {
//             curr.next = new ListNode(carry);
//         }
//         return head.next;
//     }
    
    
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;
        int x;
        int y;
        int sum;
        while(p!=null || q!=null) {
            x = (p!=null) ? p.val : 0;
            y = (q!=null) ? q.val : 0;
            sum = carry + x + y;
            // Update carry
            carry = sum / 10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        if(carry>0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    */

*/
=======
}
>>>>>>> a5dc90b9f368f271b1982c8efd1f72b2329a8167
