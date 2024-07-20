package com.example.array;

public class FindValidMatrixGivenRowandColumnSums_1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(rowSum[i] == 0)
                    break;

                if(colSum[j] == 0)
                    continue;

                int min = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return matrix;
    }
}
