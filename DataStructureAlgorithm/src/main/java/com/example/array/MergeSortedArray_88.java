package com.example.array;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        for (int j = 0; j < n; j++) {
            while(i < j + m && nums2[j] >= nums1[i])
                i++;

            for(int k = m + n - 1; k > i; k--)
                nums1[k] = nums1[k - 1];
            nums1[i] = nums2[j];
        }
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        MergeSortedArray_88 s = new MergeSortedArray_88();
        s.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
