package com.example.array;

public class AverageWaitingTime_1701 {

    public static double averageWaitingTime(int[][] customers) {
        int startTime = customers[0][0];
        double totalWaitingTime = 0, n = customers.length;
        for (int[] customer : customers) {
            if (startTime < customer[0]) {
                startTime = customer[0];
            }

            startTime += customer[1];
            totalWaitingTime += (startTime - customer[0]);
        }
        return Double.parseDouble(String.format("%.5f", totalWaitingTime / n));
    }

    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }
}
