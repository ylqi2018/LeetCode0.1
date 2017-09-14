package LinkedList;

public class IntersectionOfTwoLinkedLists160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* 
	 * Method 1, two Iteration
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// Use new references a and b in order to keep original structure
		ListNode a = headA;
		ListNode b = headB;
		
		while(a != b) {
			a = (a == null) ? headB : a.next;
			b = (b == null) ? headA : b.next;
		}
		return a;
	}
	
	/*
	 * Method 2, get the difference between the two linked list
	 */
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		ListNode a = headA;
		ListNode b = headB;
		int lenA = 0;
		int lenB = 0;
		
		while(a != null) {
			lenA++;
			a = a.next;
		}
		while(b != null) {
			lenB++;
			b = b.next;
		}
		
		a = headA;
		b = headB;
		
		if(lenA > lenB) {
			for(int i=0; i<lenA-lenB; i++) {
				a = a.next;
			}
		} else {
			for(int i=0; i<lenB-lenA; i++) {
				b = b.next;
			}
		}
		
		while(a != b) {
			a = a.next;
			b = b.next;
		}
		return a;	
	}

}
