package com.example.array;

import java.lang.reflect.Array;
import java.util.*;

public class ThirdMaximumNumber_414 {
//    public static int thirdMax(int[] nums) {
//        ArrayList<Integer> distinctNums = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//
//        for(int n: nums){
//            if(!set.contains(n)){
//                set.add(n);
//                distinctNums.add(n);
//            }
//        }
//
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        int k = 3;
//        for (int n: distinctNums) {
//            minHeap.add(n);
//
//            if(minHeap.size() > k)
//                minHeap.poll();
//        }
//
//        if(minHeap.size() == 3){
//            return minHeap.poll();
//        }
//        int result = 0;
//        while(!minHeap.isEmpty()){
//            result = minHeap.poll();
//        }
//        return result;
//    }

    public static int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for (int n: nums) {
            if(n == max1 || n == max2 || n == max3)
                continue;

            if(n > max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if(n > max2){
                max3 = max2;
                max2 = n;
            }else if(n > max3){
                max3 = n;
            }
        }

        return (max3 != Long.MIN_VALUE) ? (int) max3 : (int) max1;
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,2,2,5,3,5}));
    }
}
