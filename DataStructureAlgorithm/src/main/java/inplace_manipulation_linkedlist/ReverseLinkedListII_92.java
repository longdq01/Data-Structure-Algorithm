package inplace_manipulation_linkedlist;

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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int curIdx = 1;
        ListNode prev = null, cur = head, next = null;
        while(curIdx < left){
            prev = cur;
            cur = cur.next;
            curIdx++;
        }
        ListNode prevLeftNode = prev, leftNode = cur;
        while(curIdx <= right){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            curIdx++;
        }
        leftNode.next = cur;
        if(prevLeftNode != null){
            prevLeftNode.next = prev;
        }
        return (left == 1) ? prev : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseBetween(head, 2, 4);
    }
}
