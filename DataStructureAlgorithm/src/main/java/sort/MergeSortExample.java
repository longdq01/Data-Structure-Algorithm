package sort;

import java.util.Arrays;

public class MergeSortExample {
    public static int[] mergeSort(int[] nums, int l, int r){
        if(l > r) return new int[]{};
        if(l == r) return new int[]{nums[l]};

        int m = (l + r) / 2;
        return merge(mergeSort(nums, l, m), mergeSort(nums, m + 1, r));
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, idx = 0;
        while (i < m || j < n){
            if (i == m){
                merged[idx++] = nums2[j++];
                continue;
            } else if(j == n){
                merged[idx++] = nums1[i++];
                continue;
            }

            if(nums1[i] <= nums2[j])
                merged[idx++] = nums1[i++];
            else
                merged[idx++] = nums2[j++];
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 2, 8, 7, 6, 4};
        nums = mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 5}, new int[]{4, 6, 7, 8})));
    }
}
