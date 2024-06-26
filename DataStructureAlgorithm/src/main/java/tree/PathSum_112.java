package tree;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return traversal(root, 0, targetSum);
    }

    public boolean traversal(TreeNode root, int curSum, int target){
        if(root == null)
            return false;

        curSum += root.val;
        if(root.left == null && root.right == null){
            if(curSum == target){
                return true;
            }
        }

        boolean left = traversal(root.left, curSum, target);
        boolean right = traversal(root.right, curSum, target);
        return left || right;
    }
}
