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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        HashMap<Integer , TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];
        
            // 1. Get or create the parent node
            TreeNode parent = map.computeIfAbsent(parentVal, k -> new TreeNode(parentVal));
        
            // 2. Get or create the child node (Fixed the typo here)
            TreeNode child = map.computeIfAbsent(childVal, k -> new TreeNode(childVal));
        
            // 3. Establish the link
            if (isLeft == 1) {
                parent.left = child;
            } 
            else {
            parent.right = child;
            }
        
            // 4. Record that this node is a child
            children.add(childVal);
        }

        // 5. Find the absolute root (the node that is never a child)
        for(int key : map.keySet()){
            if(!children.contains(key)){
                return map.get(key);
            }
        }
        return null;
    }
}