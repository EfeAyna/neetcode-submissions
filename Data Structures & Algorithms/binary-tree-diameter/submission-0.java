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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), depth(root.left) + depth(root.right));
        //pure left 
        //pure right
        //inclusive --> depth left + depth right + 1

    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
