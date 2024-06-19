package recursion;

public class OptimizeRecursion {
    static long[] F = new long[1000];

    public static long Fibo(int n){
        if(F[n] != 0) return F[n]; // memorized recursion

        if(n <= 2){
            F[1] = 1;
            F[2] = 1;
            return 1;
        }

        F[n] = Fibo(n - 1) + Fibo(n - 2);
        return F[n];
    }

    public static void main(String[] args) {
        System.out.println(Fibo(5));
    }
}
