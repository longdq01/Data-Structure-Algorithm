package greedy;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int end = n - 1;
        for (int i = end - 1; i >= 0 ; i--) {
            if(nums[i] + i >= end){
                end = i;
            }
        }

        return end == 0;
    }
}
