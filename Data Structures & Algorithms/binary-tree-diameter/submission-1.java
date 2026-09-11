class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        Map<TreeNode, Integer> depth = new HashMap<>();

        stack.push(root);

        int diameter = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            // If children haven't been processed yet
            if (!visited.contains(node)) {
                visited.add(node);

                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }

            } else {
                // Children have already been processed
                stack.pop();

                int leftDepth =
                    node.left == null ? 0 : depth.get(node.left);

                int rightDepth =
                    node.right == null ? 0 : depth.get(node.right);

                diameter = Math.max(
                    diameter,
                    leftDepth + rightDepth
                );

                depth.put(
                    node,
                    1 + Math.max(leftDepth, rightDepth)
                );
            }
        }

        return diameter;
    }
}