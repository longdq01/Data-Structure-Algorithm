package sort;

import java.util.Arrays;

public class QuickSort {
//    public static void quickSort(int[] nums, int l, int r){
//        if(l >= r) return;
//        // 1. determine pivot
//        int pivot = (l + r) / 2;
//
//        // 2. partition
//        pivot = partition(nums, l, r, nums[pivot]);
//
//        // 3. recursion
//        quickSort(nums, l, pivot - 1);
//        quickSort(nums, pivot, r);
//    }
//
//    public static int partition(int[] nums, int l, int r, int key){
//        int il = l, ir = r;
//        while(il <= ir){
//            while(nums[il] < key)
//                il++;
//            while(nums[ir] > key)
//                ir--;
//            if(il <= ir){
//                int tmp = nums[il];
//                nums[il] = nums[ir];
//                nums[ir] = tmp;
//                il++;
//                ir--;
//            }
//        }
//        return il;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[]{10,80,30,90,40,50,70};
//        quickSort(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
//    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    // To print sorted array
    public static void printArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int N = arr.length;

        // Function call
        quickSort(arr, 0, N - 1);
        System.out.println("Sorted array:");
        printArr(arr);
    }
}
