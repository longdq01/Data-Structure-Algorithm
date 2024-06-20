package recursion;

public class PowerOfThree_326 {
    public static boolean isPowerOfThree(int n) {
        if(n == 3 || n == 1) return true;
        if(n <= 0 || n % 3 != 0) return false;

        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(45));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(-1));
        System.out.println(isPowerOfThree(9));


    }
}
