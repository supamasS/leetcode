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
    input: root nodes of 2 bst
    output: sorted list of node values from both trees together
    constraints: - can the trees be empty? yes, number of nodes is [0, 5000]
                 - can values be 0 or negative? yes, value is [-10^5, 10^5]
                 - what to return for empty trees? an empty list
                 - bst has only 2 possible children, left child and right child
                 - are duplicate values possible? yes
    example: - root1 = [2,1,4], root2 = [1,0,3] -> [0,1,1,2,3,4]
             - root1 = [1,null,8], root2 = [8,1] -> [1,1,8,8]
    approach: - traverse through each tree and put values in a list, then sort the list and return it
                runtime: O(nlogn), memory: O(n) where n is number of nodes in both trees together
              - since both are already bst, potentially traverse both together to find the value in order - logic will get complicated.
              - traverse tree1, add nodes to list inorder, then traverse tree2 and copy list to result list
              - can also store node values in an array
*/
class Solution {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    int index = 0;
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder1(root1);
        inorder2(root2);
        
        // copy the rest of list1
        for( ; index < list1.size(); index++) {
            list2.add(list1.get(index));
        }
        
        return list2;
    }
    
    private void inorder1(TreeNode node) {
        // base case
        if(node == null)
            return;
        
        // traverse left subtree
        inorder1(node.left);
        
        list1.add(node.val);
        
        // traverse right subtree
        inorder1(node.right);
    }
    
    private void inorder2(TreeNode node) {
        // base case
        if(node == null)
            return;
        
        // traverse left subtree
        inorder2(node.left);
        
        for( ; index < list1.size(); index++) {
            int val = list1.get(index);
            if(val <= node.val)
                list2.add(val);
            else 
                break;
        }
        
        list2.add(node.val);
        
        // traverse right subtree
        inorder2(node.right);
    }
}
