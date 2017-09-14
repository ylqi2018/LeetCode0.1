package LinkedList;

public class PalindromeLinkedList234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) {	// No node or just one node
			return true;
		}
		// Count the length of the linked list
		int length = 0;
		ListNode originHead = head;
		while(head != null) {
			length++;
			head = head.next;
		} // Finish counting the length of the linked list
		
		// Locate the mid node and reverse the second half linked list
		head = originHead;
		for(int i=0; i<length/2; i++) {
			head = head.next;
		}
		ListNode secHead;
		secHead = (length%2 == 1) ? head.next : head;
		secHead = reverse(secHead);
		
		// compare the first and second part
		while(secHead != null && originHead != null) {
			if(secHead.val != originHead.val) {
				return false;
			}
			secHead = secHead.next;
			originHead = originHead.next;
		}
		return true;		
	}
	
	private ListNode reverse(ListNode head) {
		ListNode preNode = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = preNode;
			preNode = head;
			head = next;
		}
		return preNode;
	}

}
