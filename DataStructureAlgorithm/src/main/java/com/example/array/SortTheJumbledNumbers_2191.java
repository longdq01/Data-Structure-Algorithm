package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTheJumbledNumbers_2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Integer>[] mapped = new List[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = map(nums[i], mapping, i);
        }
        quickSort(nums, 0, n -1, mapped);
        return nums;
    }

    private List<Integer> map(int num, int[] mapping, int idx){
        List<Integer> map = new ArrayList<>();
        map.add(idx);
        if(num == 0)
            map.add(mapping[0]);

        int result = 0, i = 0;
        while(num > 0){
            result += (mapping[num % 10] * (int) Math.pow(10, i++));
            num /= 10;
        }
        map.add(result);
        return map;
    }

    public void quickSort(int[] nums, int l, int r, List<Integer>[] mapped){
        if(l >= r) return;
        int pivot = (l + r) / 2;

        pivot = partition(nums, l, r, pivot, mapped);

        quickSort(nums, l, pivot - 1, mapped);
        quickSort(nums, pivot, r, mapped);
    }

    public int partition(int[] nums, int l, int r, int pivotIdx, List<Integer>[] mapped){
        int il = l, ir = r;
        List<Integer> pivot = mapped[pivotIdx];

        while(il <= ir){
            while((mapped[il].get(1) < pivot.get(1)) || (mapped[il].get(1) == pivot.get(1) && mapped[il].get(0) < pivot.get(0)))
                il++;
            while(ir >= 0 && ((mapped[ir].get(1) > pivot.get(1)) || (mapped[ir].get(1) == pivot.get(1) && mapped[ir].get(0) > pivot.get(0))))
                ir--;
            if(il <= ir){
                swap(nums, il, ir);
                swap(mapped, il, ir);
                il++;
                ir--;
            }
        }
        return il;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void swap(List<Integer>[] nums, int i, int j){
        List<Integer> tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        SortTheJumbledNumbers_2191 s = new SortTheJumbledNumbers_2191();
        System.out.println(Arrays.toString(s.sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{0,0,0,0})));
    }
}
