package cyclic_sort;

import java.util.Arrays;

public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            if(nums[i] < n && i != nums[i]){
                swap(nums, i, nums[i]);
            }else{
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if(nums[j] != j)
                return j;
        }
        return n;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        MissingNumber_268 m = new MissingNumber_268();
        m.missingNumber(new int[]{3, 0, 1});
    }
}
