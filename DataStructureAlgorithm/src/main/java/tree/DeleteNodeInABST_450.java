package tree;

public class DeleteNodeInABST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            // root is leaf node
            if(root.left == null && root.right == null)
                return null;

            // root have only left node
            if(root.left != null && root.right == null){
                return root.left;
            }

            // root have only right node
            if(root.left == null && root.right != null){
                return root.right;
            }

            // root have two node: case find left node in right tree
            TreeNode leftMostNode = findMostLeftNode(root.right);
            root.val = leftMostNode.val;
            root.right = deleteNode(root.right, leftMostNode.val);
        }
        return root;
    }

    public TreeNode findMostLeftNode(TreeNode root){
        if(root == null)
            return null;

        TreeNode leftMostNode = root;
        while(leftMostNode.left != null){
            leftMostNode = leftMostNode.left;
        }
        return leftMostNode;
    }
}
