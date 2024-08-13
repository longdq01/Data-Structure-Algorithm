package backtracking;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    List<String> paths = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backtracking(root);
        return paths;
    }

    public void backtracking(TreeNode node){
        path.add(String.valueOf(node.val));
        if(node.left == null && node.right == null){
            paths.add(String.join("->", path));
            return;
        }

        if(node.left != null){
            backtracking(node.left);
            path.remove(path.size() - 1);
        }

        if(node.right != null){
            backtracking(node.right);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths_257 b = new BinaryTreePaths_257();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(5);
        root.left = n1; root.right = n2;
        n1.right = n3;
        System.out.println(b.binaryTreePaths(root));
    }
}
