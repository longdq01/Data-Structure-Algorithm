package tree;

import java.util.*;

public class CreateBinaryTreeFromDescription_2196 {

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();
        for(int[] description: descriptions){
            int parentVal = description[0], childVal = description[1];
            TreeNode parent = map.computeIfAbsent(parentVal, TreeNode::new);
            TreeNode child = map.computeIfAbsent(childVal, TreeNode::new);

            if(description[2] == 1){
                parent.left = child;
            }else{
                parent.right = child;
            }

            childSet.add(childVal);
        }
        for(int[] description: descriptions){
            if(!childSet.contains(description[0])){
                return map.get(description[0]);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CreateBinaryTreeFromDescription_2196 c = new CreateBinaryTreeFromDescription_2196();
        TreeNode root = c.createBinaryTree(new int[][]{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}});
//        TreeNode root = c.createBinaryTree(new int[][]{{39,70,1},{13,39,1},{85,74,1},{74,13,1},{38,82,1},{82,85,1}});

    }
}
