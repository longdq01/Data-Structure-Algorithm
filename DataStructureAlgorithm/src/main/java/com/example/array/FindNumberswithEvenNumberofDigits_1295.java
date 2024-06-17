package com.example.array;

public class FindNumberswithEvenNumberofDigits_1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n: nums){
            if(n != 0 && ((int) Math.log10(n) + 1) % 2 == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        FindNumberswithEvenNumberofDigits_1295 f = new FindNumberswithEvenNumberofDigits_1295();
        System.out.println(f.findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }
}
