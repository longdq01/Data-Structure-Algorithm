package k_way_merge;

import stack_queue.ListNode;

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

        int n = lists.length;
        for (int i = 0; i < n; i++) {
            if(lists[i] != null)
                minHeap.add(lists[i]);
        }
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = node;
            if(node.next != null){
                minHeap.add(node.next);
            }
        }
        root = root.next;
        return root;
    }
}
