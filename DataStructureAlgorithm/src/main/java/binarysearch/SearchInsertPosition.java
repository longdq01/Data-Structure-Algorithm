package binarysearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r){
            int m = (l + r) / 2;
            if(nums[m] == target){
                return m;
            }else if(nums[m] < target){
                l = m + 1;
            }else{
                r = m;
            }
        }
        return l;
    }
}
