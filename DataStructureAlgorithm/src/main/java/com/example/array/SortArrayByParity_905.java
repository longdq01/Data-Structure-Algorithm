package com.example.array;

import java.util.Arrays;

public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0){
                int tmp = nums[k];
                nums[k] = nums[i];
                nums[i] = tmp;
                k++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity_905 s = new SortArrayByParity_905();
        int[] nums = s.sortArrayByParity(new int[]{3, 1, 2, 4});
        System.out.println(Arrays.toString(nums));
    }
}
