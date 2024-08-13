package slidingwindow;

public class MinimumSwapsToGroupAll1sTogetherII_2134 {
    public int minSwaps(int[] nums) {
        int count1 = 0;
        for (int num: nums) {
            if(num == 1)
                count1++;
        }
        // range of window = numbers of 1
        int l = 0, r = count1 - 1, n = nums.length, count0 = 0;
        for (int i = l; i <= r; i++) {
            if(nums[i] == 0)
                count0++;
        }
        int minSwap = count0;
        while(l < n){
            minSwap = Math.min(minSwap, count0);
            l++;
            r++;
            if(nums[l - 1] == 0)
                count0--;
            if(nums[r % n] == 0) // remove circular property
                count0++;

        }
        return minSwap;
    }

    public static void main(String[] args) {
        MinimumSwapsToGroupAll1sTogetherII_2134 m = new MinimumSwapsToGroupAll1sTogetherII_2134();
        m.minSwaps(new int[]{0,1,0,1,1,0,0});
    }
}
