package tree;


import java.util.*;

public class NumberofGoodLeafNodesPairs_1530 {
    Set<TreeNode> visited = new HashSet<>();


    public int countPairs(TreeNode root, int distance) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        List<TreeNode> leaves = new ArrayList<>();
        postOrderTraversal(root, null, parent, leaves);
        int count = 0;
        for(TreeNode leaf: leaves){
            visited = new HashSet<>();
            count += dfs(leaf, distance, 0, parent);
        }
        return count / 2;
    }

    private int dfs(TreeNode node, int distance, int curDistance, HashMap<TreeNode, TreeNode> parent){
        visited.add(node);
        if(node.left == null && node.right == null && curDistance > 0){
            return 1;
        }

        if(curDistance == distance)
            return 0;

        int count = 0;
        if(node.left != null && !visited.contains(node.left)){
            count += dfs(node.left, distance, curDistance + 1, parent);
        }

        if(node.right != null && !visited.contains(node.right)){
            count += dfs(node.right, distance, curDistance + 1, parent);
        }

        if(parent.get(node) != null && !visited.contains(parent.get(node))){
            count += dfs(parent.get(node), distance, curDistance + 1, parent);
        }
        return count;
    }

    private void postOrderTraversal(TreeNode node, TreeNode parentNode, HashMap<TreeNode, TreeNode> parent, List<TreeNode> leaves){
        if(node == null)
            return;

        postOrderTraversal(node.left, node, parent, leaves);
        postOrderTraversal(node.right, node, parent, leaves);
        if(node.left == null && node.right == null){
            leaves.add(node);
        }
        parent.put(node, parentNode);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        root.left = n1; root.right = n2;
        n1.right = n3;

        NumberofGoodLeafNodesPairs_1530 n = new NumberofGoodLeafNodesPairs_1530();
        System.out.println(n.countPairs(root, 3));
    }
}
