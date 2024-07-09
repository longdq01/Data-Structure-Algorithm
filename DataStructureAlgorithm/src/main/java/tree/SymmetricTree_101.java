package tree;

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null)
            return true;

        if(leftNode != null && rightNode != null){
            if(leftNode.val != rightNode.val)
                return false;

            return isSymmetric(leftNode.left, rightNode.right) &&
                    isSymmetric(leftNode.right, rightNode.left);
        }

        return false;
    }
}
