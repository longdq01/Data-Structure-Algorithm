package com.example.array;

public class BinarySearchExample {
    public static int binarySearch(int[] nums, int val){
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(val == nums[m])
                return m;
            else if(val < nums[m])
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }

    public static int binarySearch2(int[] nums, int val, int l, int r){
        if (r < l) return -1;
        int m = (l + r) / 2;
        if(nums[m] == val) return m;

        if(val < nums[m])
            return binarySearch2(nums, val, l, m - 1);
        return binarySearch2(nums, val, m + 1, r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5};
        System.out.println(binarySearch2(nums, 0, 0, nums.length - 1));
    }
}
