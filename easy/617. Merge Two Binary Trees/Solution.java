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
    input: nodes root1, root2
    output: root of merged tree, with corresponding nodes' values added together
    constraints: - can root be null? Yes, number of nodes is [0,2000]
                 - can node.val be negative or 0? Yes, node.val is [-10^4, 10^4]
                 - if one tree's node is null but the other tree's node is not, use the non-null node
                 
    examples:    - root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
                    output: [3,4,5,5,4,null,7]
                 - root1 = [1], root2 = [1,2]
                    output: [2,2]
                    
    approach: traverse through both trees in the same order, dfs or bfs - dfs
    
    mergeTrees() {
        return mergedNodeDfs(root1, root2);
    }
    
    private TreeNode mergedNodeDfs(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null)
            return null;
            
        if(node1 == null)
            return node2
        else if(node2 == null)
            return node1
        
        // neither is null
        node1.val += node2.val                                  // node1.val = 3, node1.val = 4
        node1.left = mergedNodeDfs(node1.left, node2.left);     // 
        node1.right = mergedNodeDfs(node1.right, node2.right);
        return node1;        
    }
*/
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergedNodeDfs(root1, root2);
    }
    
    private TreeNode mergedNodeDfs(TreeNode node1, TreeNode node2) {
        // Not needed since it's already covered in the next if statement below
        // if(node1 == null && node2 == null)
        //     return null;
            
        if(node1 == null)
            return node2;
        else if(node2 == null)
            return node1;
        
        // neither is null
        node1.val += node2.val;                                 // node1.val = 3, node1.val = 4
        node1.left = mergedNodeDfs(node1.left, node2.left);     
        node1.right = mergedNodeDfs(node1.right, node2.right);
        return node1;        
    }    
}
