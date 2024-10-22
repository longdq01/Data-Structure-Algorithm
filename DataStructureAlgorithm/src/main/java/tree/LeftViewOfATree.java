package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeftViewOfATree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> traversal = new ArrayList<Integer>();
        HashMap<Integer, Integer> traversalLevel = new HashMap<>();
        traverseLeft(root, traversalLevel, 0);
        for(int i = 0; i < traversalLevel.size(); i++){
            traversal.add(traversalLevel.get(i));
        }
        return traversal;
    }

    public void traverseLeft(TreeNode root, HashMap<Integer, Integer> traversalLevel, int level) {
        if(root == null)
            return;

        traversalLevel.putIfAbsent(level, root.val);
        traverseLeft(root.left, traversalLevel, level + 1);
        traverseLeft(root.right, traversalLevel, level + 1);
    }
}
