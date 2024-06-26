package com.example.array;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(dp[i], maxSum);
        }

        return maxSum;
    }
}
