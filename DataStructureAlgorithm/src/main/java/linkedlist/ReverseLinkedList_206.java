package linkedlist;

public class ReverseLinkedList_206 {
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

    static class Solution {
        public static ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) return head;

            ListNode res = reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return res;
        }


        public static void main(String[] args) {
            ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
            list1 = reverseList(list1);

        }
    }
}
