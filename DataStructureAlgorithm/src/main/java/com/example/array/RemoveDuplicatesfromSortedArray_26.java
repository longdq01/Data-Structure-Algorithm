package com.example.array;

public class RemoveDuplicatesfromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int k = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            if(nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray_26 r = new RemoveDuplicatesfromSortedArray_26();
        System.out.println(r.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
