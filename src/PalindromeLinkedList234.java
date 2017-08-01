import interview.ListNode;

public class PalindromeLinkedList234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null) {
			slow = slow.next;
		}
		
		slow = reverse(slow);
		fast = head;
		
		while(slow != null) {
			if(fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
				
	}
	
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		while(head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	
    public boolean isPalindrome1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // if there are odd nodes in the list, make right part smaller
        if(fast != null) {
            slow = slow.next;
        }
        
        slow = reverse1(slow);
        fast = head;
        
        while(slow != null) {
            if(slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    // reverse
    public ListNode reverse1(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
	
	

}
