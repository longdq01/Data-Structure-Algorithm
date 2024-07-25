package com.example.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumbersinAMatrix_1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, idx = 0;
        int[] minRow = new int[m], maxCol = new int[n];

        for (int[] row : matrix) {
            int min = row[0];
            for (int j = 0; j < n; j++) {
                min = Math.min(min, row[j]);
                maxCol[j] = Math.max(maxCol[j], row[j]);
            }
            minRow[idx++] = min;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(minRow[j] == maxCol[i])
                    result.add(maxCol[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LuckyNumbersinAMatrix_1380 l = new LuckyNumbersinAMatrix_1380();
        System.out.println(l.luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));

    }
}
