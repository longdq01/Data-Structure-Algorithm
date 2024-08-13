package com.example.array;

import java.util.Arrays;
import java.util.HashMap;

public class LunarSeeker {
    public int lunarSeeker(int[] A, int B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int d: A) {
            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }

        Arrays.sort(A);
        for (int j : A) {
            if (freq.get(j) >= B)
                return j;
        }
        return -1;
    }
}
