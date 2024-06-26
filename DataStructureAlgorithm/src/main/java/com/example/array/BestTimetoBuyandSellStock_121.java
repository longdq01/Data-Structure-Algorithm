package com.example.array;

public class BestTimetoBuyandSellStock_121 {
    public int maxProfit(int[] prices) {
        int maxProfit = -1, minVal = prices[0];
        for (int price: prices) {
            minVal = Math.min(minVal, price);
            maxProfit = Math.max(maxProfit, price - minVal);
        }
        return maxProfit;
    }
}
