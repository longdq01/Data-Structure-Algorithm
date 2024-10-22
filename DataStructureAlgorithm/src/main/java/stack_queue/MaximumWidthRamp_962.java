package stack_queue;

import java.util.List;
import java.util.Stack;

public class MaximumWidthRamp_962 {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int maxRamp = 0;
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]){
                stack.push(i);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                maxRamp = Math.max(maxRamp, i - stack.peek());
                stack.pop();
            }
        }
        return maxRamp;
    }

    public static void main(String[] args) {
        Object abc = null;
        List<String> lst = null;

    }
}
