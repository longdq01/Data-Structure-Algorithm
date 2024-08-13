package cyclic_sort;


public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int idx = 0, n = nums.length;
        while(idx < n){
            if(nums[idx] > 0 && nums[idx] < n && idx != nums[idx] - 1 && nums[idx] != nums[nums[idx] - 1]){
                swap(nums, idx, nums[idx] - 1);
            }else{
                idx++;
            }
        }
//        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        FirstMissingPositive_41 f = new FirstMissingPositive_41();
        System.out.println(f.firstMissingPositive(new int[]{1,1}));
    }
}
