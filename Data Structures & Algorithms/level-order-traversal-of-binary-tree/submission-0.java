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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if(root == null){
            return res;
        }
        q.offer(root);

        int n = 1;
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode x = q.poll();
                
                if(x.left != null) q.offer(x.left);
                if(x.right != null) q.offer(x.right);
                list.add(x.val);
                
            }

            res.add(list);
            n = q.size();
        }
        return res;

    }
}
