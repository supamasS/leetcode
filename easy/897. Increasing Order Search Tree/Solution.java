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
    output: an in-order tree
    constraints: - can values be negative or 0? [0, 1000]
                 - how large could a tree be? empty tree? [1,100]
                 - each node has right child only, left child is null
    examples:   [5,3,6,2,4,null,8,1,null,null,null,7,9]
                        -> [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
                [5,1,7] -> [1,null,5,null,7]
    approach:   dfs to leaf node, create new node with val = node.val and assign it to curNode.right
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode();
        dfs(root, newRoot);
        return newRoot.right;
    }    
    
    private TreeNode dfs(TreeNode node, TreeNode curNode) {
        if(node == null)
            return curNode;
            
        curNode = dfs(node.left, curNode);
        // create new node with new node's val = node.val
        curNode.right = new TreeNode(node.val);
        curNode = dfs(node.right, curNode.right);
        return curNode;
    }
*/
class Solution {    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode();
        
        dfs(root, newRoot);
        return newRoot.right;
    }    
    
    private TreeNode dfs(TreeNode node, TreeNode curNode) {
        if(node == null)
            return curNode;
            
        curNode = dfs(node.left, curNode);
        
        // create new node with new node's val = node.val
        curNode.right = new TreeNode(node.val);
        // System.out.println(node.val + " " + curNode.right.val);
        
        curNode = dfs(node.right, curNode.right);
        return curNode;
    }
}
