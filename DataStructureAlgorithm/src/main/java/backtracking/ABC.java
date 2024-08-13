package backtracking;

import tree.TreeNode;

import java.util.*;

public class ABC {
//    public static int[] findErrorNums(int[] nums) {
//        int n = nums.length, i = 0;
//        while(i < n){
//            if(nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]){
//                swap(nums, i, nums[i] - 1);
//            }else{
//                i++;
//            }
//        }
//
//        for (int j = 0; j < n; j++) {
//            if(nums[j] - 1 != j){
//                return new int[]{nums[j], j + 1};
//            }
//        }
//
//        return new int[]{};
//    }
//
//    private static void swap(int[] nums, int i, int j){
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }

    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int d: deck) {
            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }

        ArrayList<Integer> lst = new ArrayList<>();
        for (int key: freq.keySet()) {
            lst.add(freq.get(key));
        }

        int min = Collections.min(lst);
        if(min < 2)
            return false;
        for (int v: lst){
            if(v % min != 0){
                return false;
            }
        }
        return true;
    }

    public int lunarSeeker(int[] A, int B) {
        int n = A.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int d: A) {
            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }

        Arrays.sort(A);
        for (int j : A) {
            if (freq.get(j) >= B)
                return j;
        }
        return -1;
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 3})));
    }
}
