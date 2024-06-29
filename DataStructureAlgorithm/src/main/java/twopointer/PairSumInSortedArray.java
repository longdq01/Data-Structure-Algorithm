package twopointer;

// Given a sorted array of integers, find a pair in the array that sums to a number T.
public class PairSumInSortedArray {
    public int[] pairSum(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while (i < j){
            int sum = nums[i] + nums[j];
            if(sum == target)
                return new int[]{i, j};
            else if(sum < target)
                i++;
            else
                j--;
        }
        return null;
    }
}
