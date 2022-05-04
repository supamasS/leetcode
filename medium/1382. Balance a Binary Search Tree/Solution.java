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
    input: root node to a tree
    output: a new balanced tree
    constraints: - can it be empty? No, the number of nodes is [1, 10^4]
                 - can val be 0 or negative? No, val is [1, 10^5]
                 - do we have to preserve the nodes or ok to create new nodes? create
    approach:    - store nodes in a sorted list, BST - use in-order traversal so it's already sorted
                 - build a new tree from the middle of the list, similar to binary search
*/
class Solution {
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        createList(root);
        
        TreeNode newRoot = createBBST(0, list.size()-1);
        return newRoot;
    }
    
    // store nodes in a list with in-order traversal - since it's BST, result is already sorted 
    private void createList(TreeNode node) {
        if(node == null)
            return;
        
        createList(node.left);
        list.add(node.val);
        createList(node.right);
    }
    
    //  0 1 2 3
    // [1,2,3,4]
    //
    // createBBST(0,3) -> mid = (0+3)/2 = 1 -> node.val = 2
    //   createBBST(0,0) -> mid = 0 -> node.val = 1, node.left = null, node.right = null
    //      createBBST(0,-1) -> return null
    //      createBBST(1,0) -> return null
    //   createBBST(2,3) -> mid = 2 -> node.val = 3, node.left = null, node.right = null
    //      createBBST(2,1) -> return null
    //      createBBST(3,3) -> mid = 3 -> node.val = 4
    //          createBBST(3,2) -> return null
    //          createBBST(4,3) -> return null
    
    // create a new tree starting from middle of the list, similar to binary search
    private TreeNode createBBST(int left, int right) {
        if(left > right)
            return null; // need to return sth
        
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(list.get(mid));
        
        node.left = createBBST(left, mid-1);
        node.right = createBBST(mid+1, right);
        
        return node;
    }
}
