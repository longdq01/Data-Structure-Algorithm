package stack_queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = m - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i], -1);
            }else{
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < n; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
