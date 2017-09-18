import interview.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++) {
        	hm.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, hm);
    }
    
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> hm) {
    	if(preStart > preEnd || inStart > inEnd) {
    		return null;	// When preStart > preEnd or inStart > inEnd, finish iterating
    	}
    	
    	TreeNode root = new TreeNode(preorder[preStart]);
    	int inRoot = hm.get(root.val);
    	int numElements = inRoot - inStart;
    	root.left = buildTree(preorder, preStart+1, preStart+numElements, inorder, inStart, inRoot-1, hm);
    	root.right = buildTree(preorder, preStart+numElements+1, preEnd, inorder, inRoot+1, inEnd, hm);
    	return root;
    }
	
}

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) { val = x; }
//}
