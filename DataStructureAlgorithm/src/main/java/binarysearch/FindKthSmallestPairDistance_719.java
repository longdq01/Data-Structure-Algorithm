package binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthSmallestPairDistance_719 {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1];
        while(l < r){
            int m = (l + r) / 2;
            int pairs = counting_pairs(nums, m);

            if(pairs < k)
                l = m + 1;
            else
                r = m;
        }
        return r;
    }

    public static int counting_pairs(int[] nums, int diff){
        int l = 0, r = 1, count = 0;
        while(r < nums.length){
            if(nums[r] - nums[l] <= diff){
                count += r - l;
                r++;
            }else{
                l++;
            }
        }
        return count;
    }
}
