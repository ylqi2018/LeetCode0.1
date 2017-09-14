package LinkedList;


public class MergeKSortedLists23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        return mergeHelper(lists, 0, lists.length-1);
    }
    
    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        int mid = start + (end - start)/2;
        ListNode l1 = mergeHelper(lists, start, mid);
        ListNode l2 = mergeHelper(lists, mid+1, end);
        return mergeTwo(l1, l2);
    }
    
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
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
        if(l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        return dummy.next;
    }
	
	
// waiting for debug
/*
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
*/
}
