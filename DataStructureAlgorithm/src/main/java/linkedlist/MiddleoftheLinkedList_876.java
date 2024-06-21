package linkedlist;

public class MiddleoftheLinkedList_876 {
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
        public ListNode middleNode(ListNode head) {
            int length = 0;
            ListNode tmp = head;
            while(tmp != null){
                length++;
                tmp = tmp.next;
            }

            ListNode res = head;
            for (int i = 1; i <= length/2; i++){
                res = res.next;
            }
            return res;
        }
    }
}
