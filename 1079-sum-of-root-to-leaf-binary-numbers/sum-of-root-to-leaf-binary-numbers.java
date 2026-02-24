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
    int totalSum = 0;
    public int sumRootToLeaf(TreeNode root) 
    {
        StringBuilder path = new StringBuilder();
        dfs(root , path);

        return totalSum;
    }
    public void dfs(TreeNode root ,StringBuilder path)
    {
        if(root == null)
        return;

        // 1. Append current value
        path.append(root.val);

        // 2. Check if it's a leaf node
        if(root.left == null && root.right == null){
            int decimal = Integer.parseInt(path.toString() , 2);
            totalSum += decimal;
        }
        else{
            // 3. Recurse to children
            dfs(root.left , path);
            dfs(root.right , path);
        }
        // 4. Backtrack: Remove the last character
        path.deleteCharAt(path.length()-1);
    }
}