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
class Solution {
    public boolean checkTree(TreeNode root) {
        /*  input: exactly 3 nodes: root, left, right
            output: boolean - true if root.val = left.val + right.val
            values: int between -100, 100 inclusive
            Example: [10,4,6] - true
                     [5,3,1] - false
            Approach: add the 2 children's values and return whether it's equal to root.val
        */
        
        return (root.left.val + root.right.val) == root.val;
    }
}
