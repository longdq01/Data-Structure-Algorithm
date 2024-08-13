package com.example.array;

import java.util.Arrays;

public class SpiralMatrixIII_885 {
    int[][] traversal;
    int rows, cols, rStart, cStart, idx;
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        traversal = new int[rows * cols][2];
        this.rows = rows;
        this.cols = cols;
        this.rStart = rStart;
        this.cStart = cStart;
        spiralMatrixHelper(rStart, cStart);

        return traversal;
    }

    public void spiralMatrixHelper(int i, int j){
        int range = j - cStart + 1;
        if(helper(i, j)){
            traversal[idx++] = new int[]{i, j};
        }
        if(cStart - range < 0 && cStart + range >= cols && rStart - range < 0 && rStart + range >= rows){
            return;
        }
        for (int k = i; k <= rStart + range; k++) {
            if(helper(k, cStart + range))
                traversal[idx++] = new int[]{k, cStart + range};
        }
        for (int k = cStart + range - 1; k >= cStart - range; k--) {
            if(helper(rStart + range, k))
                traversal[idx++] = new int[]{rStart + range, k};
        }
        for (int k = rStart + range - 1; k >= rStart - range; k--) {
            if(helper(k, cStart - range))
                traversal[idx++] = new int[]{k, cStart - range};
        }
        for (int k = cStart - range + 1; k <= cStart + range - 1; k++) {
            if(helper(rStart - range, k))
                traversal[idx++] = new int[]{rStart - range, k};
        }
        spiralMatrixHelper(i - 1, j + 1);
    }

    private boolean helper(int i, int j){
        if(i < 0 || i >= rows)
            return false;
        if(j < 0 || j >= cols)
            return false;
        return true;
    }

    public static void main(String[] args) {
        SpiralMatrixIII_885 s = new SpiralMatrixIII_885();
        System.out.println(Arrays.deepToString(s.spiralMatrixIII(3, 2, 2, 1)));
    }
}
