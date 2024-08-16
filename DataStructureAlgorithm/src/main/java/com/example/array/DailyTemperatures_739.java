package com.example.array;

import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monotonicStack = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while(!monotonicStack.isEmpty() && temperatures[i] >= temperatures[monotonicStack.peek()]){
                int tmp = monotonicStack.pop();
                count += ans[tmp];
            }

            if(monotonicStack.isEmpty())
                ans[i] = 0;
            else
                ans[i] = count + 1;
            monotonicStack.push(i);
        }
        return ans;
    }
}
