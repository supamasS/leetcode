/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
    input: array of int in preorder
    output: root to the BST according to the array's preorder elements
    constraints: - can array be empty? No, preorder.length is [1,100]
                 - can values be 0 or negative? no, preorder[i] is [1,1000]
                 - can values be duplicate? no, values are unique
                 - is the tree balanced? no mention, so probably not always
                 
    examples:    - [8,5,1,7,10,12] -> [8,5,10,1,7,null,12]
            index   0 1 2 3  4  5
                    0 -> left 1, right 4
                    1 -> left 2, right 3
                    2 -> left null, right null (not shown in output array above)
                    3 -> left null, right null (not shown in output array above)
                    4 -> left null, right 5
                 - [1,3] -> [1,null,3]
    approaches:  - sequential loop - need a way to keep track of all nodes along the path to know if next node is larger and should be in the right subtree - a stack? no, just send the node value along with min and max in recursion
                 - use binary search to find right child and build it breadth-first, left child is next one if smaller
            
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int index, int min, int max) {
        // index = 1, min = MIN, max = 8
        // index = 2, min = MIN, max = 5
        // index = 3, min = MIN, max = 1
        // index = 3, min = 1, max = 5
        // index = 1, min = 5, max = 8        
        
        
        // base case
        if(index >= preorder.length || preorder[index] < min || preorder[index] > max)
            return null;
            
        int val = preorder[index++];  // val = 5, index = 2
                                      // val = 1, index = 3

        TreeNode node = new TreeNode(val);
        node.left = helper(preorder, index, min, val);  // node.val = 1, node.left = null
        
        node.right = helper(preorder, index, val, max); // node.val = 1, node.right = null
                                                        // node.val = 5
        
        return node;
    }
*/
class Solution {
    int index = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int min, int max) {             
        // base case
        if(index >= preorder.length || preorder[index] < min || preorder[index] > max)
            return null;
            
        int val = preorder[index++];  

        TreeNode node = new TreeNode(val);
        node.left = helper(preorder, min, val);  
        
        node.right = helper(preorder, val, max);
        
        return node;
    }
}
