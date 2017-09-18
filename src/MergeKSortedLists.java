
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import interview.ListNode;

public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public ListNode mergeKLists(ListNode[] lists) {
		
	}
	
	public ListNode partion(ListNode[] lists, int s, int e) {
		if(s==e) {
			return lists[s];
		}
		
		if(s < e) {
			int q = (s + e)/2;
			ListNode l1 = partion(lists, s, q);
			ListNode l2 = partion(lists, q+1, e);
			return merge(l1, l2);
		} else {
			return null;
		}
	}
	
	
	
	
	
	
	
	public ListNode mergeKLists1(List<ListNode> lists) {
		if(lists == null || lists.size() == 0) {
			return null;
		}
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val < o2.val) {
					return -1;
				} else if(o1.val == o1.val) {
					return 0;
				} else {
					return 1;
				}
			}
			
		});
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		for(ListNode node: lists) {
			if(node != null) {
				queue.add(node);
			}
		}
		
		while(!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;
			
			if(tail.next != null) {
				queue.add(tail.next);
			}
		}
		
		return dummy.next;
	}

}
