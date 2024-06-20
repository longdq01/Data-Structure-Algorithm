package sort;

public class SortanArray_912 {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int[] mergeSort(int[] nums, int l, int r){
        if(l > r) return new int[]{};
        if(l == r) return new int[]{nums[l]};

        int m = (l + r) / 2;
        return merge(mergeSort(nums, l, m), mergeSort(nums, m + 1, r));
    }

    public int[] merge(int[] nums1, int[] nums2) {
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
}
