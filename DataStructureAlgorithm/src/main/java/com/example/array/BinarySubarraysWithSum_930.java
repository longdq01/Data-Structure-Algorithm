package com.example.array;

public class BinarySubarraysWithSum_930 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int l = 0, r = 0, sum = 0, n = nums.length, count = 0;

        while(r < n){
            sum += nums[r];

            while(sum > goal && l <= r){
                sum -= nums[r];
                l++;
            }

            if(sum == goal)
                count++;
            r++;
        }

        while(l + 1 < n){
            sum -= nums[l];
            if(sum == goal){
                int tmp = n - 1, sumTmp = sum;
                count++;
                while(l + 1 < tmp){
                    sumTmp -= nums[tmp];
                    if(sumTmp == goal){
                        count++;
                    }else
                        break;
                    tmp--;
                }

            }
            else // sum < goal
                break;
            l++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }
}
