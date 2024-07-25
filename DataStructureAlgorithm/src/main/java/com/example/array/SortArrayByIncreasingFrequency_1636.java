package com.example.array;

import java.util.*;

public class SortArrayByIncreasingFrequency_1636 {
    HashMap<Integer, Integer> frequency = new HashMap<>();
    public int[] frequencySort(int[] nums) {
        for(int num: nums){
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int r = nums.length - 1;
        quickSort(nums, 0, r, r);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r, int pivot){
        if(l < r){
            pivot = partition(nums, l, r, nums[pivot]);
            quickSort(nums, l, pivot - 1, pivot - 1);
            quickSort(nums, pivot + 1, r, r);
        }
    }

    private int partition(int[] nums, int l, int r, int key){
        int i = l - 1, freqKey = frequency.get(key);
        for (int j = l; j <= r - 1; j++) {
            int freq = frequency.get(nums[j]);
            if(freq == freqKey){
                if(nums[j] > key){
                    i++;
                    swap(nums, i, j);
                }
            }else if(freq < freqKey){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        SortArrayByIncreasingFrequency_1636 s = new SortArrayByIncreasingFrequency_1636();
        System.out.println(Arrays.toString(s.frequencySort(new int[]{1,1,2,2,2,3})));

    }
}
