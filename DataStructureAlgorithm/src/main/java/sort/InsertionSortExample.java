package sort;

import java.util.Arrays;


public class InsertionSortExample {
    public static int[] insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 0, 2, 7, 6, 4, 8};
        System.out.println(Arrays.toString(insertionSort(nums)));
    }
}
