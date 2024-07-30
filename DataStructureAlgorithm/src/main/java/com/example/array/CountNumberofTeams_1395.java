package com.example.array;

public class CountNumberofTeams_1395 {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if(rating[j] > rating[i]){
                    for (int k = j + 1; k < n; k++) {
                        if(rating[k] > rating[j])
                            count++;
                    }
                }else if(rating[j] < rating[i]){
                    for (int k = j + 1; k < n; k++) {
                        if(rating[k] < rating[j])
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
