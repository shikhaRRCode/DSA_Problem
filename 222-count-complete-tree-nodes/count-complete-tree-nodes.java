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
    public int countNodes(TreeNode root) {
        //going far left as possible to find Height
        int lH = leftHeight(root);
        int rH = rightHeight(root);

        if(lH == rH){
            return (1 << (lH+1) ) - 1;  
        }

        return count(root);

    }
    public int leftHeight(TreeNode root){
        if(root == null){
            return -1;
        }

        return 1 + leftHeight(root.left);
    }
    public int rightHeight(TreeNode root){
        if(root == null){
            return -1;
        }

        return 1 + rightHeight(root.right);
    }
    public int count(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }
}