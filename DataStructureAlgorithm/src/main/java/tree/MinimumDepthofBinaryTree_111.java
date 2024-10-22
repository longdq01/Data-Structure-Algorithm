package tree;

public class MinimumDepthofBinaryTree_111 {
    public int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, 1);
        return minDepth;
    }

    public void helper(TreeNode root, int depth) {
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth, depth);
            return;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}
