package com.example.array;

public class SearchInsertPosition_35 {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] == target)
                return m;
            else if(nums[m] < target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
