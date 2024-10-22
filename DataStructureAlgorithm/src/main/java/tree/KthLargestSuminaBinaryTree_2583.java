package tree;

import java.util.ArrayList;
import java.util.List;

public class KthLargestSuminaBinaryTree_2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sum = new ArrayList<Long>();
        traversal(root, 0, sum);
        sum.sort((o1, o2) -> Long.compare(o2, o1));
        if(k > sum.size())
            return -1;
        return sum.get(k - 1);
    }

    public void traversal(TreeNode root, int level, List<Long> sum) {
        if(root == null){
            return;
        }
        if(level + 1 > sum.size()){
            sum.add(0L);
        }
        sum.set(level, sum.get(level) + root.val);
        traversal(root.left, level + 1, sum);
        traversal(root.right, level + 1, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode r1 = new TreeNode(8);
        TreeNode r2 = new TreeNode(9);
        TreeNode r3 = new TreeNode(2);
        TreeNode r4 = new TreeNode(1);
        TreeNode r5 = new TreeNode(3);
        TreeNode r6 = new TreeNode(7);
        root.left = r1; root.right = r2;
        r1.left = r3; r1.right = r4;
        r2.left = r5; r2.right = r6;
        KthLargestSuminaBinaryTree_2583 k = new KthLargestSuminaBinaryTree_2583();
        k.kthLargestLevelSum(root, 4);
    }
}
