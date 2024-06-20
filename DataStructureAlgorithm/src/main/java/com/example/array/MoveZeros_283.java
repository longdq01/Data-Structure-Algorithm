package com.example.array;

import java.util.Arrays;

public class MoveZeros_283 {
    public static void moveZeroes(int[] nums) {
        int idx = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] != 0)
                nums[idx++] = nums[i];
        }
        while(idx < n){
            nums[idx++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
