package com.example.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumOccurrencesMap = new HashMap<>();
        int count = 0, sum = 0, n = nums.length;
        sumOccurrencesMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if(sumOccurrencesMap.containsKey(sum - k)){
                count += sumOccurrencesMap.get(sum - k);
            }
            sumOccurrencesMap.put(sum, sumOccurrencesMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}
