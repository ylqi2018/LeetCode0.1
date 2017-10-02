package DivideAndConquer;

import java.util.Arrays;
import java.util.List;

public class DivideAndConquer {
	
	class Node{
		Node left;	// The value of left < the value of node
		Node right;	// The value of right > the value of node
		int val;	// The node value
		int sum;	// recording the total number on its left
		int dup;	// count the duplication
		
		public Node(int v, int s) {
			val = v;
			sum = s;
		}
		
	}

	public List<Integer> countSmaller(int[] nums) {
		Integer[] ans = new Integer[nums.length];
		Node root = null;
		for(int i=nums.length-1; i>=0; i--) {
			root = insert(nums[i], root, ans, i, 0);
		}
		return Arrays.asList(ans);
	}
	
	private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
		if(node == null) {	// If node==null, create the node
			node = new Node(num, 0);	// the total num on its left is zero
			ans[i] = preSum;	// preSum is 0
		} else if(node.val == num){
			node.dup++;
			ans[i] = preSum + node.sum;	// preSum is 0, sum not change
		} else if(node.val > num) {
			node.sum++;	// the total num on its left++
			ans[i] = preSum + node.sum;	// ans will plus 1
		} else if(node.val < num) {
			node.right = insert(num, node.right, ans, i, preSum+node.dup+node.sum);
		}
		return node;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
