package tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal_590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> traversals = new ArrayList<>();
        postorder(root, traversals);
        return traversals;
    }

    public void postorder(Node root, List<Integer> traversals){
        if(root == null)
            return;
        for(Node node: root.children){
            postorder(node, traversals);
        }
        traversals.add(root.val);
    }
}
