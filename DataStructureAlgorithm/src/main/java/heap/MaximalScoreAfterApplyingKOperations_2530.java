package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations_2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            maxHeap.add(num);
        }

        long score = 0;
        for (int i = 0; i < k; i++) {
            int _max = maxHeap.poll();
            score += _max;
            maxHeap.add((int) Math.ceil((double) _max / 3));
        }
        return score;
    }
}
