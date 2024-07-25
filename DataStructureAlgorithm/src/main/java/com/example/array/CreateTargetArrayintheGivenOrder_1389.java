package com.example.array;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayintheGivenOrder_1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        int n = nums.length;
        int[] target2 = new int[n];

        for (int i = 0; i < n; i++) {
            target.add(index[i], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            target2[i] = target.get(i);
        }
        return target2;
    }
}
