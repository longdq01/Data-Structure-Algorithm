package tree;

import com.sun.source.tree.Tree;

public class MyBST {
    public TreeNode root;

    public MyBST() {
    }

//    public void insert(int value){
//        TreeNode node = new TreeNode(value);
//        if(root == null){
//            return;
//        }
//
//        TreeNode cur = root;
//        while(true){
//            if(value > cur.val){
//                if(cur.right == null){
//                    cur.right = node;
//                    return;
//                }
//                cur = cur.right;
//            }else{
//                if(cur.left == null){
//                    cur.left = node;
//                    return;
//                }
//                cur = cur.left;
//            }
//        }
//    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        }else{
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
