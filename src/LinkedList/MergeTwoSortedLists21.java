package LinkedList;

public class MergeTwoSortedLists21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// normal
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		curr.next = l1;
        		l1 = l1.next;
        	} else {
        		curr.next = l2;
        		l2 = l2.next;
        	}
        	curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
    
    // fastest
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        result.next = l1;
        ListNode pre=result;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        while(l1!=null)
        {
            if(l1.val>l2.val)
            {
                ListNode nowPos=pre.next;
                pre.next=l2;
                l1=pre.next;
                l2=nowPos;
            }
            l1=l1.next;
            pre=pre.next;
        }
        pre.next=l2;
        return result.next;
    }
    
    // faster
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	if(l1.val < l2.val) {
    		l1.next = mergeTwoLists2(l1.next, l2);
    		return l1;
    	} else {
    		l2.next = mergeTwoLists2(l1, l2.next);
    		return l2;
    	}
    }

}
