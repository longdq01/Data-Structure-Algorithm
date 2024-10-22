package tree;

public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traversal(p, q);
    }

    public boolean traversal(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }
        return traversal(p.left, q.left) || traversal(p.right, q.right);
    }
}
