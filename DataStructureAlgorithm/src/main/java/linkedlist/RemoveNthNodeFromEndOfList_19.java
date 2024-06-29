package linkedlist;

public class RemoveNthNodeFromEndOfList_19 {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head, right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }
}
