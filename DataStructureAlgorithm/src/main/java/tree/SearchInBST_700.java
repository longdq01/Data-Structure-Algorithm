package tree;

public class SearchInBST_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;

        TreeNode cur = root;
        while(true){
            if(cur == null)
                return null;

            if(cur.val == val)
                return cur;
            else if(val < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
    }
}
