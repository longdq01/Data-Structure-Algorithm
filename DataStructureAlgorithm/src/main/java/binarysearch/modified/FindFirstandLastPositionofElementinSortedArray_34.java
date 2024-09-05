package binarysearch.modified;

public class FindFirstandLastPositionofElementinSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int l = binarySearch(nums, target, true);
        int r = binarySearch(nums, target, false);

        return new int[]{l, r};
    }

    public int binarySearch(int[] nums, int target, boolean searchLeft){
        int l = 0, r = nums.length - 1, idx = -1;
        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] == target){
                idx = m;
                if(searchLeft){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            } else if(nums[m] > target){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return idx;
    }
}
