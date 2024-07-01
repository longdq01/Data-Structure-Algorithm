package slidingwindow;

public class MinimumSizeSubarraySum_209 {
    int sum = 0;
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0, minLen = Integer.MAX_VALUE;
        int i = 0, j = 0, n = nums.length;
        while(j < n){
            sum += nums[j];
            if(sum < target)
                j++;
            else{
                while(sum >= target){
                    sum -= nums[i];
                    i++;
                }
                minLen = Math.min(minLen, j - i + 2);
                j++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}
