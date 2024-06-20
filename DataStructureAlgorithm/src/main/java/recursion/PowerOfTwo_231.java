package recursion;

public class PowerOfTwo_231 {
//    public static boolean isPowerOfTwo(int n) {
//        if(n == 2 || n == 1) return true;
//        if(n <= 0 || n % 2 != 0) return false;
//
//        return isPowerOfTwo(n / 2);
//    }

    public static boolean isPowerOfTwo(int n) {
        if(n <= 0 || (n != 1 && n % 4 != 0)) return false;
        double l = Math.log(n) / Math.log(4);

        int r = (int) l;
        return l - r <= 10e-5;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16385));
        System.out.println(isPowerOfTwo(50));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(17));

    }
}
