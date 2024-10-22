package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> traversals = new ArrayList<List<Integer>>();
        traversal(root, 0, traversals);
        List<List<Integer>> traversals2 = new ArrayList<List<Integer>>();
        for (int i = traversals.size() - 1; i >= 0; i--) {
            traversals2.add(traversals.get(i));
        }
        return traversals2;
    }

    public void traversal(TreeNode root, int level, List<List<Integer>> traversals) {
        if(root == null){
            return;
        }

        if(traversals.size() == level){
            traversals.add(new ArrayList<>());
        }
        traversals.get(level).add(root.val);
        traversal(root.left, level + 1, traversals);
        traversal(root.right, level + 1, traversals);
    }
}
