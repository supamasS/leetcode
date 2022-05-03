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
    int sum = 0;
    
    public int sumRootToLeaf(TreeNode root) {
        /*  input: root node of a binary tree (2 children at each node)
            output: sum of all root-to-leaf value represented as binary numbers
            constraints: - each node.val is either 0 or 1 - binary
                         - root represents the most significant bit, leaf is the least significant bit
                         - is the tree balanced, ie all path is the same length? no, can be any length
                         - can root be null? no, [1,1000] nodes
                         - binary tree, only left and right children
                         - can a node have one child but the other is null? yes
            Example: [1,0,1,0,1,0,1] -> (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
                          ^
                val.  1
                        2
                        2+1 = 3
                        3*2 = 6
                        6 + 1 = 7
                sum = 4 + 5 = 9
                sum = 6 + 7 = 13
            Approach:    - dfs, multiply current value by 2 at each depth, add to sum when a leaf is found
            
            int sum=0   // instance variable
            
            dfs(root, 0);
            return sum;
            
            int dfs(TreeNode node, int val) {
                // base cases
                if(node == null)
                    return
                    
                val = val*2 + node.val
                
                if(node.left == null && node.right == null)
                    sum += val
                    return
                                
                dfs(node.left, val)
                dfs(node.right, val)
            }
        */
        
        dfs(root, 0);
        
        return sum;
    }
    
    private void dfs(TreeNode node, int val) {
        // base case
        if(node == null)
            return;
        
        val = (val << 1) | node.val;    // val*2 + node.val 
        
        // leaf node
        if(node.left == null && node.right == null) {
            sum += val;
            return;
        }

        dfs(node.left, val);
        dfs(node.right, val);
    }
}
