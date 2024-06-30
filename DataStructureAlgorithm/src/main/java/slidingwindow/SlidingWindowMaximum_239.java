package slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0, n = nums.length;
        int[] output = new int[n - k + 1];

        int i = 0;
        while(i < n){
            if(!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.removeFirst();

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);

            i++;
            if(i >= k){
                output[idx] = nums[deque.peekFirst()];
                idx++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7, 2, 4}, 2)));
    }
}
