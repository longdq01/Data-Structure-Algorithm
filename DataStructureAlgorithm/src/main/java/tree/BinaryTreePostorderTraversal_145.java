package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        if(root == null)
            return traversals;

        traversals.addAll(postorderTraversal(root.left));
        traversals.addAll(postorderTraversal(root.right));
        traversals.add(root.val);
        return traversals;
    }
}
