package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSquareStreakInAnArray_2501 {
    public int longestSquareStreak(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int streak = -1;

        Arrays.sort(nums);
        for(int num: nums){
            int sqrt = (int) Math.sqrt(num);
            if(sqrt * sqrt == num){
                if(map.containsKey(sqrt)){
                    int curStreak = map.get(sqrt) + 1;
                    streak = Math.max(streak, curStreak);
                    map.put(num, curStreak);
                }
            }
            map.putIfAbsent(num, 1);
        }
        return streak;
    }

    public static void main(String[] args) {
        LongestSquareStreakInAnArray_2501 l = new LongestSquareStreakInAnArray_2501();
        l.longestSquareStreak(new int[]{4,3,6,16,8,2});
    }
}
