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
    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return null;
        }
        // if(root.right == null && root.left == null){
        //     return root;
        // }
        // if(root.right == null){
        //     root.right = invertTree(root.left);
        //     return root;
        // }
        // if(root.left == null){
        //     root.left = invertTree(root.right);
        //     return root;
        // }

        TreeNode newL = invertTree(root.right);
        TreeNode newR = invertTree(root.left);
        root.left = newL;
        root.right = newR;
        return root;
    }
}
