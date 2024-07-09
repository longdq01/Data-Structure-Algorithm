package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    List<List<Integer>> traversals = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        traversal(root, 0);
        return traversals;
    }

    public void traversal(TreeNode root, int level){
        if(root == null)
            return;

        if(traversals.size() == level)
            traversals.add(new ArrayList<>());
        List<Integer> currentTraversal = traversals.get(level);
        currentTraversal.add(root.val);

        traversal(root.left, level + 1);
        traversal(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        root.left = n1; root.right = n2;
        n2.left = n3; n2.right = n4;

//        System.out.println(levelOrder(root));
    }
}
