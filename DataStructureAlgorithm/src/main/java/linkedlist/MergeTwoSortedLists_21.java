package linkedlist;

public class MergeTwoSortedLists_21 {
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
        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = null;
            ListNode tail = null;
            ListNode current1 = list1;
            ListNode current2 = list2;

            while (current1 != null && current2 != null) {
                if (current1.val <= current2.val) {
                    if (head == null) {
                        head = current1;
                        tail = head;
                    } else {
                        tail.next = current1;
                        tail = tail.next;
                    }
                    current1 = current1.next;
                } else {
                    if (head == null) {
                        head = current2;
                        tail = head;
                    } else {
                        tail.next = current2;
                        tail = tail.next;
                    }
                    current2 = current2.next;
                }
            }
            while (current1 != null) {
                if (head == null) {
                    head = current1;
                    tail = head;
                } else {
                    tail.next = current1;
                    tail = tail.next;
                }
                current1 = current1.next;
            }
            while (current2 != null) {
                if (head == null) {
                    head = current2;
                    tail = head;
                } else {
                    tail.next = current2;
                    tail = tail.next;
                }
                current2 = current2.next;
            }
            return head;
        }

        public static void main(String[] args) {
            ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
            ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
            ListNode node = mergeTwoLists(list1, list2);

        }
    }


}
