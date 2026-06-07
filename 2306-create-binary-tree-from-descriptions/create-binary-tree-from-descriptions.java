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

        TreeNode root = null;
        for(int i = 0 ; i < n ; i++){
            TreeNode parent;
            TreeNode child;
            int isLeft = descriptions[i][2];
            if(map.containsKey(descriptions[i][0])){
                parent = map.get(descriptions[i][0]);
            }
            else{
                parent = new TreeNode(descriptions[i][0]);
                map.put(descriptions[i][0] , parent);
            }

            if(map.containsKey(descriptions[i][1])){
                child = map.get(descriptions[i][1]);
            }
            else{
                child = new TreeNode(descriptions[i][1]);
                map.put(descriptions[i][1] , child);
            }
            children.add(descriptions[i][1]);

            if(isLeft == 1){
                parent.left = child;
            }
            else{
                parent.right = child;
            }

        }

        for(int key : map.keySet()){
            if(!children.contains(key)){
                return map.get(key);
            }
        }
        return null;
    }
}