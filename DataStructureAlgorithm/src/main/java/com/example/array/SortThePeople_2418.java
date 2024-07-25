package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortThePeople_2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        quickSort(names, heights, 0, n - 1);
        System.out.println(Arrays.toString(heights));
        return names;
    }

    public void quickSort(String[] names, int[] heights, int l, int r){
        if(l >= r) return;
        int pivot = (l + r) / 2;

        pivot = partition(names, heights, l, r, heights[pivot]);

        quickSort(names, heights, l, pivot - 1);
        quickSort(names, heights, pivot, r);
    }

    public int partition(String[] names, int[] heights, int l, int r, int key){
        int il = l, ir = r;
        while(il <= ir){
            while(heights[il] > key)
                il++;
            while(heights[ir] < key)
                ir--;
            if(il <= ir){
                int tmp = heights[il];
                heights[il] = heights[ir];
                heights[ir] = tmp;

                String tmp2 = names[il];
                names[il] = names[ir];
                names[ir] = tmp2;

                il++;
                ir--;
            }
        }
        return il;
    }

    public static void main(String[] args) {
        SortThePeople_2418 s = new SortThePeople_2418();
//        s.sortPeople(new int[]{"Mary", "John", "Emma"}, new int[1)
    }
}
