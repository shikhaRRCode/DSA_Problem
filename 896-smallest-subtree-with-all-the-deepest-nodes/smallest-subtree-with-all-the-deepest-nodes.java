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
    public TreeNode subtreeWithAllDeepest(TreeNode root) 
    {
        return solve(root).node;
    }
    public pair solve(TreeNode root){
        if(root == null){
            return new pair(0 , null);
        }

        pair l = solve(root.left);
        pair r = solve(root.right);

        if(l.depth == r.depth){
            return new pair(l.depth+1 , root);
        }
        else if(l.depth > r.depth){
            return new pair(l.depth+1 , l.node);
        }
        else{
            return new pair(r.depth+1 , r.node);
        }
    }
    class pair{
        int depth;
        TreeNode node;

        pair(int depth , TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }
}