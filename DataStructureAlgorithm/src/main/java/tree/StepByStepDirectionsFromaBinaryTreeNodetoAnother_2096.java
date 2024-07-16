package tree;

public class StepByStepDirectionsFromaBinaryTreeNodetoAnother_2096 {
    class Path{
        StringBuilder path = new StringBuilder();
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lowestCommonAncestor(root, startValue, destValue);

        // start -> lca -> dest
        Path startPath = new Path();
        Path destPath = new Path();

        findPath(lca, startValue, startPath);
        findPath(lca, destValue, destPath);
        return "U".repeat(startPath.path.length()) + destPath.path.toString();
    }

    public boolean findPath(TreeNode root, int dest, Path p){
        if(root == null)
            return false;

        if (root.val == dest) {
            return true;
        }

        p.path.append("R");
        if(findPath(root.right, dest, p)){
            return true;
        }
        p.path.deleteCharAt(p.path.length() - 1);

        p.path.append("L");
        if(findPath(root.left, dest, p)){
            return true;
        }
        p.path.deleteCharAt(p.path.length() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int startValue, int destValue) {
        if (root == null)
            return null;

        if (root.val == startValue || root.val == destValue)
            return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, startValue, destValue);
        TreeNode rightNode = lowestCommonAncestor(root.right, startValue, destValue);

        if (leftNode != null && rightNode != null)
            return root;

        return (leftNode != null) ? leftNode : rightNode;
    }

    public static void main(String[] args) {
        StepByStepDirectionsFromaBinaryTreeNodetoAnother_2096 s = new StepByStepDirectionsFromaBinaryTreeNodetoAnother_2096();

        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(2);
        root.left = n1; root.right = n2;
        n1.left = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6;
        n6.right = n7;
        s.getDirections(root, 2, 1);

    }
}
