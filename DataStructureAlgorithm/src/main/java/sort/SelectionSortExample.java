package sort;

import java.util.Arrays;

public class SelectionSortExample {
    public static int[] selectionSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[min_idx] > nums[j]){
                    min_idx = j;
                }
            }
            int tmp = nums[min_idx];
            nums[min_idx] = nums[i];
            nums[i] = tmp;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 0, 2, 7, 6, 4, 8};
        System.out.println(Arrays.toString(selectionSort(nums)));
    }
}