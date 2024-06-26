package com.example.array;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i: nums) {
            result ^= i;
        }
        return result;
    }
}
