package tree;

import java.util.HashMap;

public class CousinsInBinaryTreeII_2641 {
    HashMap<Integer, Integer> sumMap = new HashMap<>();
    HashMap<TreeNode, Integer> valOfChildren = new HashMap<>();

    public TreeNode replaceValueInTree(TreeNode root) {
        traverse(root, null, 0);
        traverseAndReplaceValueInTree(root, null, 0);
        return root;
    }

    public void traverse(TreeNode root, TreeNode parent, int level){
        if(root == null){
            return;
        }
        sumMap.put(level, sumMap.getOrDefault(level, 0) + root.val);
        valOfChildren.put(parent, valOfChildren.getOrDefault(parent, 0) + root.val);

        traverse(root.left, root, level + 1);
        traverse(root.right, root, level + 1);
    }

    public void traverseAndReplaceValueInTree(TreeNode root, TreeNode parent, int level){
        if(root == null){
            return;
        }
        int sum = sumMap.get(level);
        if(parent == null){
            sum = 0;
        }else{
            sum -= valOfChildren.get(parent);
        }
        root.val = sum;
        traverseAndReplaceValueInTree(root.left, root, level + 1);
        traverseAndReplaceValueInTree(root.right, root, level + 1);
    }
}
