package com.example.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public static List<String> summaryRanges(int[] nums) {
        int l = 0, r = 1, n = nums.length;
        List<String> result = new ArrayList<>();
        while(r < n){
            if((long) nums[r] - nums[r - 1] > 1){
                result.add(l != r - 1 ? nums[l] + "->" + nums[r - 1] : nums[l] + "");
                l = r;
            }
            r++;
        }
        result.add(l != r - 1 ? nums[l] + "->" + nums[r - 1] : nums[l] + "");
        return result;
    }

    public static void main(String[] args) {
        summaryRanges(new int[]{-2147483648,-2147483647,2147483647});
    }
}
