package k_way_merge;

import java.util.PriorityQueue;

public class MedianOfTwoSortedArrays_4 {
    // O(log (m+n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0, k = 0;

        int[] nums = new int[n1 + n2];
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }else{
                nums[k++] = nums2[j++];
            }
        }
        if(i == n1){
            while (j < n2){
                nums[k++] = nums2[j++];
            }
        }else{
            while (i < n1){
                nums[k++] = nums1[i++];
            }
        }

        if((n1 + n2) % 2 != 0)
            return nums[(n1 + n2) / 2];

        int m = (n1 + n2) / 2;
        return (double) (nums[m - 1] + nums[m]) / 2;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays_4 m = new MedianOfTwoSortedArrays_4();
        m.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
    }
}
