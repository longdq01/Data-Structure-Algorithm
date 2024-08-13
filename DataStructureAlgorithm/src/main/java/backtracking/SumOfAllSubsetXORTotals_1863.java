package backtracking;


public class SumOfAllSubsetXORTotals_1863 {
    int[] arr;
    int n;
    int sum;

    public int subsetXORSum(int[] nums) {
        n = nums.length;
        arr = new int[n];
        backtracking(0, nums);
        return sum;
    }

    public void backtracking(int i, int[] nums){
        for (int j = 0; j <= 1; j++) {
            arr[i] = j;
            if(i == n - 1){
                int tmp = 0;
                for (int k = 0; k < n; k++) {
                    if(arr[k] == 1)
                        tmp ^= nums[k];
                }
                sum += tmp;
            }else{
                backtracking(i + 1, nums);
            }
        }
    }

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals_1863 s = new SumOfAllSubsetXORTotals_1863();
        System.out.println(s.subsetXORSum(new int[]{1,5,6}));
    }
}
