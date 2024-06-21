package linkedlist;

public class RemoveLinkedListElements_203 {
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

    public static ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
                head = head.next;
        }

        if(head == null)
            return null;

        ListNode previous = head;
        ListNode current = head.next;
        while(current != null){
            if(current.val == val){
                previous.next = current.next;
            }else{
                previous = current;
            }
            current = current.next;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6)))))));
        head = removeElements(head, 6);
    }
}
