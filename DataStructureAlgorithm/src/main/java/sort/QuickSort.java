package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums, int l, int r){
        if(l >= r) return;
        // 1. determine pivot
        int pivot = (l + r) / 2;

        // 2. partition
        pivot = partition(nums, l, r, nums[pivot]);

        // 3. recursion
        quickSort(nums, l, pivot - 1);
        quickSort(nums, pivot, r);
    }

    public static int partition(int[] nums, int l, int r, int key){
        int il = l, ir = r;
        while(il <= ir){
            while(nums[il] < key)
                il++;
            while(nums[ir] > key)
                ir--;
            if(il <= ir){
                int tmp = nums[il];
                nums[il] = nums[ir];
                nums[ir] = tmp;
                il++;
                ir--;
            }
        }
        return il;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 7, , -10};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
