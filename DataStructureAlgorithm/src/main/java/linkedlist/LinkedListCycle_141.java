package linkedlist;

import java.util.List;

public class LinkedListCycle_141 {
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

    public static class Solution {
        public static boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast.equals(slow)){
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
//            ListNode head1 = new ListNode(2);
//            head.next = head1;
//            ListNode head2 = new ListNode(0);
//            head1.next = head2;
//            ListNode head3 = new ListNode(-4);
//            head2.next = head3;
            System.out.println(hasCycle(head));
        }
    }
}
