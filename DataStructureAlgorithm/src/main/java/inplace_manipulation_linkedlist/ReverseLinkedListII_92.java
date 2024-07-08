package inplace_manipulation_linkedlist;


import linkedlist.LinkedListCycle_141;

import java.util.List;



public class ReverseLinkedListII_92 {
    public static class ListNode{
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
//    public static ListNode reverseBetween(ListNode head, int left, int right) {
//        int curIdx = 1;
//        ListNode prev = null, cur = head, next = null;
//        while(curIdx < left){
//            prev = cur;
//            cur = cur.next;
//            curIdx++;
//        }
//        ListNode prevLeftNode = prev, leftNode = cur;
//        while(curIdx <= right){
//            next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//            curIdx++;
//        }
//        leftNode.next = cur;
//        if(prevLeftNode != null){
//            prevLeftNode.next = prev;
//        }
//        return (left == 1) ? prev : head;
//    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // move prev to node immediately before the sublist to be reversed add .
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        // cur point to left node
        ListNode cur = prev.next;

        // Reverse the portion of the linked list between left and right positions
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = cur.next;
            cur.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseBetween(head, 2, 4);
    }
}
