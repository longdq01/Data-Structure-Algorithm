package backtracking;

import tree.TreeNode;

import java.util.*;

public class ABC {
    public static int arraySign(int[] nums) {
        int prod = 1;
        for (int num : nums) {
            prod *= Integer.compare(num, 0);
        }
        return prod;
    }

    public int findLucky(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = -1;
        for (int key: map.keySet()){
            if(key == map.get(key)){
                max = Math.max(key, max);
            }
        }
        return max;
    }


    public int Tribonacci(int n) {
        Integer[] dp = new Integer[38];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;

        return util(n, dp);
    }

    public int util(int n, Integer[] dp){
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;

        int d1, d2, d3;
        if(dp[n - 1] == null){
            dp[n - 1] = util(n - 1, dp);
        }
        if(dp[n - 2] == null){
            dp[n - 2] = util(n - 2, dp);
        }
        if(dp[n - 3] == null){
            dp[n - 3] = util(n - 3, dp);
        }
        d1 = dp[n - 1];
        d2 = dp[n - 2];
        d3 = dp[n - 3];

        return d1 + d2 + d3;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(prev == 0 && flowerbed[i] == 0 && n > 0){
                flowerbed[i] = 1;
                n--;
            }

            if(prev == 1 && flowerbed[i] == 1){
                n++;
            }
            prev = flowerbed[i];
        }

        return n == 0;
    }

    public int distMoney(int money, int children) {
       if(money < children)
           return -1;
       money -= children;
       if(money < 7)
           return 0;
       int count = 0;
       while(money >= 7 && children > 0){
           money -= 7;
           children--;
           count++;
       }
       if(money > 0 && children == 0)
           return count - 1;
       if(money == 3 && children == 1)
           return count - 1;
       return count;
    }

    public boolean isPowerOfFour(int n) {
        double tmp = (Math.log(n) / Math.log(4));
        return tmp - (int) tmp == 0;
    }

    public static void main(String[] args) {
    }
}
