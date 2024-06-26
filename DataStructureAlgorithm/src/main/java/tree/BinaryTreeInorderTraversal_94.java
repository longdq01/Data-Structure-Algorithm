package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        if(root == null)
            return traversals;

        traversals.addAll(inorderTraversal(root.left));
        traversals.add(root.val);
        traversals.addAll(inorderTraversal(root.right));
        return traversals;
    }
}
