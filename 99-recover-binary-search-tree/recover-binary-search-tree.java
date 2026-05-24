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
    TreeNode prev = null , first = null , second = null;
    public void recoverTree(TreeNode root) 
    {
        inOrder(root);

        //swapping
        int val = first.val;
        first.val = second.val;
        second.val = val; 
    }
    public void inOrder(TreeNode root){
        //Base case:
        if(root == null){
            return;
        }

        //LST
        inOrder(root.left);
        //middle condition
        if(prev != null && root.val < prev.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        //RST
        inOrder(root.right);
    }
}