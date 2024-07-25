package com.example.array;

public class BestTimetoBuyandSellStockII_122 {
    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        int curStock = prices[0], maxCurStock = curStock;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if(prices[i] > maxCurStock){
                maxCurStock = prices[i];
            }else{
                totalProfit += (maxCurStock - curStock);
                curStock = prices[i];
                maxCurStock = curStock;
            }
        }
        totalProfit += (maxCurStock - curStock);
        return totalProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
