package linkedlist;

public class RemoveDuplicatesfromSortedList_83 {
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

    static class Solution{
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null)
                return null;

            ListNode current = head.next;
            ListNode previous = head;
            while(current != null){
                if(current.val == previous.val){
                    previous.next = current.next;
                }else{
                    previous = current;
                }
                current = current.next;
            }
            return head;
        }
    }

}
