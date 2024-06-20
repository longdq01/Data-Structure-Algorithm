package recursion;

public class PowerOfFour_342 {
    public boolean isPowerOfFour(int n) {
        if(n <= 0 || (n != 1 && n % 4 != 0)) return false;
        double l = Math.log(n) / Math.log(4);

        int r = (int) l;
        return l - r <= 10e-5;
    }
}
