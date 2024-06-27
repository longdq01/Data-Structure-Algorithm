package com.example.array;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int j = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if(nums[i] + i >= j)
                j = i;
        }

        return j == 0;
    }
}
