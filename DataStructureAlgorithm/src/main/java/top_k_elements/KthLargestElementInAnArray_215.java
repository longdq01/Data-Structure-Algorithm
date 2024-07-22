package top_k_elements;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = nums.length, i = 0;
        for (i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        while(i < n){
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
            i++;
        }
        return minHeap.poll();
    }
}
