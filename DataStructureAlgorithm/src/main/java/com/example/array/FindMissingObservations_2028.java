package com.example.array;

public class FindMissingObservations_2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, s = 0;
        for(int num: rolls){
            s += num;
        }
        int rest = mean * (n + m) - s;
        int[] res = new int[n];
        if(rest < n || n * 6 < rest)
            return new int[0];

        for (int i = 0; i < n; i++) {
            int a = rest / (n - i);
            res[i] = a;
            rest -= a;
        }
        return res;
    }
}
