package tree;

import java.util.*;

public class DeleteNodesAndReturnForest_1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n: to_delete){
            set.add(n);
        }

        int curIdx = 0;
        forest.add(root);
        while(curIdx < forest.size()){
            TreeNode node = forest.get(curIdx);
            if(set.contains(node.val)){
                forest.remove(curIdx);
                if(node.left != null){
                    forest.add(node.left);
                }
                if(node.right != null){
                    forest.add(node.right);
                }
            }else{
                bfs(node, forest, set);
                curIdx++;
            }
        }

        return forest;
    }

    private void bfs(TreeNode root, List<TreeNode> forest, Set<Integer> set){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left != null){
                if(set.contains(node.left.val)){
                    forest.add(node.left);
                    node.left = null;
                }else{
                    queue.add(node.left);
                }
            }
            if(node.right != null){
                if(set.contains(node.right.val)){
                    forest.add(node.right);
                    node.right = null;
                }else{
                    queue.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        root.left = n2; root.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6; n3.right = n7;

        DeleteNodesAndReturnForest_1110 d = new DeleteNodesAndReturnForest_1110();
        List<TreeNode> result = d.delNodes(root, new int[]{3,5});
        for (TreeNode node: result){
            System.out.println(node.val);
        }
    }
}
