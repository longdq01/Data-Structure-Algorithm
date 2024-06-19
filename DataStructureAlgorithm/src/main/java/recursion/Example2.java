package recursion;

public class Example2 {
    public static void print(int[] nums, int index){
        if(index == nums.length) return;

        System.out.println("index " + index + ": " + nums[index]);
        print(nums, index + 1);
    }

    static int maxValue = 0;
    public static void maxInArray(int[] nums, int index){
        if(index == nums.length) return;

        maxValue = Math.max(maxValue, nums[index]);
        maxInArray(nums, index + 1);
    }

    public static int maxInArray2(int[] nums, int initValue, int index){
        if(index == nums.length) return initValue;

        initValue = Math.max(initValue, nums[index]);
        return maxInArray2(nums, initValue,index + 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 0, 9, 3, 8};
        print(nums, 0);
        maxInArray(nums, 0);
        System.out.println(maxValue);
        System.out.println(maxInArray2(nums, 0, 0));

    }
}
