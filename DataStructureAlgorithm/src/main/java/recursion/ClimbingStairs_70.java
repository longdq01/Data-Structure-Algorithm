package recursion;

public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int n1 = 1, n2 = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = n1 + n2;
            n1 = n2;
            n2 = c;
        }

        return c;
    }

    public static void main(String[] args) {

    }
}
