package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {
    PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1 - o2);
    int k;

    public KthLargestElementInAStream_703(int k, int[] nums) {
        this.k = k;
        for (int num: nums){
            heap.add(num);
            if(heap.size() > k)
                heap.poll();
        }
    }

    public int add(int val) {
        heap.add(val);
        if(heap.size() > k)
            heap.poll();
        return heap.peek();
    }

    public static void main(String[] args) {
//        KthLargestElementInAStream_703 k = new KthLargestElementInAStream_703(3, new int[]{5,4,8,2});
//        System.out.println(k.add(3));
    }
}
