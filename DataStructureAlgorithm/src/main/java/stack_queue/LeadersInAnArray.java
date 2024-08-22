package stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeadersInAnArray {
    public List<Integer> leaders(int []nums, int n) {
        int prev = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if(nums[i] >= prev){
                prev = nums[i];
                stack.add(prev);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
