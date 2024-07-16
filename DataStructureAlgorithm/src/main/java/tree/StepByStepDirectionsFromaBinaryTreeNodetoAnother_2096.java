package tree;

import java.util.*;

public class StepByStepDirectionsFromaBinaryTreeNodetoAnother_2096 {
    ArrayList<Integer> nodes = new ArrayList<>();
    Queue<TreeNode> bfs = new ArrayDeque<>();
    int startIdx, destIdx, curIdx = 1;

    StringBuilder directions = new StringBuilder();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        traversal(root, startValue, destValue);
        goUp();
        directions.append(goDown());
        return directions.toString();
    }

    private void goUp(){
        // check destIdx is not bottom of startIdx
        int x = log2((double) destIdx / startIdx);
        int level = (int) Math.pow(2, x);
        while(!(startIdx * level <= destIdx && destIdx <= startIdx * level + level - 1)){
            directions.append("U");
            startIdx /= 2;
            x = log2((double) destIdx / startIdx);
            level = (int) Math.pow(2, x);
        }
    }

    private String goDown(){
        StringBuilder sb = new StringBuilder();
        while(destIdx != startIdx){
            if(destIdx % 2 != 0)
                sb.append("R");
            else
                sb.append("L");
            destIdx /= 2;
        }
        return sb.reverse().toString();
    }

    private int log2(double a){
        return (int) (Math.log(a) / Math.log(2));
    }

    private void traversal(TreeNode root, int startValue, int destValue){
        bfs.add(root);

        while(!bfs.isEmpty()){
            TreeNode node = bfs.poll();
            if(node.val != 0){
                if(node.val == startValue)
                    startIdx = curIdx;
                if(node.val == destValue)
                    destIdx = curIdx;
                nodes.add(node.val);
                bfs.add(node.left == null ? new TreeNode(0) : node.left);
                bfs.add(node.right == null ? new TreeNode(0) : node.right);
            }else{
                nodes.add(null);
            }
            curIdx++;
        }
    }

    public static void main(String[] args) {
        StepByStepDirectionsFromaBinaryTreeNodetoAnother_2096 s = new StepByStepDirectionsFromaBinaryTreeNodetoAnother_2096();

        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(2);
        root.left = n1; root.right = n2;
        n1.left = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6;
        n6.right = n7;
        s.getDirections(root, 2, 1);
        System.out.println(s.directions);
    }
}
