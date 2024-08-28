package linkedlist;

import java.util.Stack;

public class MiddleOfTheLinkedlist {
    public Node middleNode(Node head) {
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(Node head) {
        Stack<Node> stack = new Stack<>();
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            stack.add(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(slow != null){
            if(stack.isEmpty())
                return false;

            Node st = stack.pop();
            if(st.val != slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }
}
