package com.example.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
    public static int majorityElement(int[] nums) {
        int n = nums.length, vote = 0, candidate = (int) (-1e9 - 1);
        for (int num : nums) {
            if(num != candidate){
                vote--;
            }else{
                vote++;
            }

            if(vote <= 0){
                candidate = num;
                vote = 1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,1,2,2,2}));
    }
}
