package sort;

import java.util.Arrays;

public class BubbleSortExample {
    public static int[] bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]){
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }   

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 0, 2, 7, 6, 4, 8};
        System.out.println(Arrays.toString(bubbleSort(nums)));
    }
}
