package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersecOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> output = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 < n2){
            for (int i = 0; i < n2; i++) {
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
            }
            for (int i = 0; i < n1; i++) {
                int count = map.getOrDefault(nums1[i], 0);
                if(count > 0){
                    output.add(nums1[i]);
                    map.put(nums1[i], --count);
                }
            }
        }else{
            for (int i = 0; i < n1; i++) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }
            for (int i = 0; i < n2; i++) {
                int count = map.getOrDefault(nums2[i], 0);
                if(count > 0){
                    output.add(nums2[i]);
                    map.put(nums2[i], --count);
                }
            }
        }

        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 1, 2, 2}, new int[]{2, 2})));
    }
}
