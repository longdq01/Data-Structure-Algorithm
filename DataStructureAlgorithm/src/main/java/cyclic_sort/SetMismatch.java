package cyclic_sort;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length, i = 0;
        while(i < n){
            if(nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }else{
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if(nums[j] - 1 != j){
                return new int[]{nums[j], j + 1};
            }
        }

        return new int[]{};
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
