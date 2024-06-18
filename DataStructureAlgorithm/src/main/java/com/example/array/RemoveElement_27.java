package com.example.array;

import java.util.Arrays;

public class RemoveElement_27 {
//    public int removeElement(int[] nums, int val) {
//        int k = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] != val){
//                nums[k] = nums[i];
//                k++;
//            }
//        }
//        return k;
//    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if(nums[i] == val){
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j+1];
                }
                n--;
            }else{
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        RemoveElement_27 r = new RemoveElement_27();
        var nums = new int[]{3,2,2,3};
        System.out.println(r.removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }
}

