import interview.ListNode;

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode headA = new ListNode(1);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(5);
		ListNode a4 = new ListNode(7);
		ListNode a5 = new ListNode(9);
		headA.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		
		ListNode headB = new ListNode(2);
		ListNode b2 = new ListNode(3);
		ListNode b3 = new ListNode(7);
		headB.next = b2;
		b2.next = b3;
		
		ListNode a = new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headB);
		System.out.println(a.val);
		
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) {
			return null;
		}
		
		ListNode a = headA;
		ListNode b = headB;
		
		while(a != b) {
			a = a==null? headB : a.next;
			b = b==null? headA : b.next;
		}
		
		return a;
	}

}
