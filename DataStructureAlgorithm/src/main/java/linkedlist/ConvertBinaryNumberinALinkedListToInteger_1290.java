package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertBinaryNumberinALinkedListToInteger_1290 {

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
        public int getDecimalValue(ListNode head) {
            int sum = 0;

            while (head != null){
                sum *= 2;
                sum += head.val;
                head = head.next;
            }
            return sum;
        }
    }
}
