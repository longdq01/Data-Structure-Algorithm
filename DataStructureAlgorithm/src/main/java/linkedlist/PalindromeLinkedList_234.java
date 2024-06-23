package linkedlist;

import java.util.Stack;

/*
[0]
[1,6,6,1]
[1,1,6,1]
[1,6,1,1]
[6,1,1,1]
[1,1,1,6]
[1,6,1,6]
[1,6,6,6,1]
*/

public class PalindromeLinkedList_234 {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null) return true;

            Stack<Integer> stack = new Stack<>();
            ListNode slow = head, fast = head;
            while(fast != null && fast.next != null){
                stack.push(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }
            // skip middle if length is odd
            if(fast != null){
                slow = slow.next;
            }
            while (slow != null){
                if(stack.pop() != slow.val)
                    return false;
                slow = slow.next;
            }
            return true;
        }
    }
}
