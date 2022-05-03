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

/*  input: root node, targetSum int value
    output: list of list of integers - path values that sum up to targetSum
    constraints: - can node.val be negative or 0? yes, node.val is [-1000, 1000]
                 - can targetSum be negative or 0? yes, targetSum is [-1000, 1000]
                 - complete binary tree? no
                 - can output be empty list? yes
    examples:    - root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
                    output = [[5,4,11,2],[5,8,4,5]]
                 - root = [1,2,3], targetSum = 5
                    output = []
                 - root = [1,2], targetSum = 0
                    output = []
    approach:    - dfs, sum and build list along the path
                 - at leaf node check if sum == targetSum, build path
                 - would be nice to build the path on the way back once that path is known to be included, but it gets complicated
    
    sum is not instance variable, but accumulated along the path
    List<List<Integer>> list = new ArrayList<>(); // instance variable

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> curList = new ArrayList<>();
        dfs(root, targetSum, 0, curList);
        return list;        
    }

    private void dfs(TreeNode node, int targetSum, int sum, List<Integer> curList) {
        // base case
        if(node == null)
            return
            
        sum += node.val
        curList.add(node.val);
        
        // leaf node
        if(node.left == null && node.right == null)
            if(sum == targetSum)
                List<Integer> newList = new ArrayList<>(curList);
                list.add(newList);
                
        dfs(node.left, targetSum, sum, curList);
        dfs(node.right, targetSum, sum, curList);
        curList.remove(curList.size()-1);
    }
    
*/

class Solution {
    List<List<Integer>> list = new ArrayList<>(); // instance variable
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> curList = new ArrayList<>();
        dfs(root, targetSum, 0, curList);
        return list;        
    }
    
    private void dfs(TreeNode node, int targetSum, int sum, List<Integer> curList) {
        // base case
        if(node == null)
            return;
            
        sum += node.val;
        curList.add(node.val);
        
        // leaf node
        if(node.left == null && node.right == null)
            if(sum == targetSum) {
                List<Integer> newList = new ArrayList<>(curList);
                list.add(newList);
            }
                
        dfs(node.left, targetSum, sum, curList);
        dfs(node.right, targetSum, sum, curList);
        
        curList.remove(curList.size()-1);
    }    
}
