package tree;

public class LowestCommonAncestorofaBinaryTree_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode != null && rightNode != null)
            return root;

        return (leftNode != null) ? leftNode : rightNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(4);
        root.left = n1; root.right = n2;
        n1.left = n3; n1.right = n4;
        n2.left = n5; n2.right = n6;
        n4.left = n7; n4.right = n8;

        LowestCommonAncestorofaBinaryTree_236 l = new LowestCommonAncestorofaBinaryTree_236();
        System.out.println(l.lowestCommonAncestor(root, n1, n8));
    }

}
