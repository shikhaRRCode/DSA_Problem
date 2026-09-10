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
    int matchingNodeCount;
    public int averageOfSubtree(TreeNode root) {
        matchingNodeCount = 0;
        calculateSubtreeStats(root);

        return matchingNodeCount;
    }
    // Helper returns an array of size 2: [sumOfSubtree, totalNodeCount]
    private int[] calculateSubtreeStats(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // Post-order traversal: process left and right children first
        int[] leftStats = calculateSubtreeStats(node.left);
        int[] rightStats = calculateSubtreeStats(node.right);

        int currentSum = leftStats[0] + rightStats[0] + node.val;
        int currentCount = leftStats[1] + rightStats[1] + 1;

        // Integer division automatically rounds down to the nearest integer
        if (currentSum / currentCount == node.val) {
            matchingNodeCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}