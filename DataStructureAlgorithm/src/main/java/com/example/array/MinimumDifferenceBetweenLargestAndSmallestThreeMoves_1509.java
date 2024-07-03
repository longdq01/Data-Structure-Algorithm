package com.example.array;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestThreeMoves_1509 {
    public static int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4){
            return 0;
        }
        Arrays.sort(nums);
        int min = Math.min(nums[n - 2] - nums[2], nums[n - 3] - nums[1]);
        min = Math.min(nums[n - 1] - nums[3], min);
        min = Math.min(nums[n - 4] - nums[0], min);
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{82,81,95,75,20}));
    }
}
