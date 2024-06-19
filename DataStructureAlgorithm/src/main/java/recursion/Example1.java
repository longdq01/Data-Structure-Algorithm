package recursion;

public class Example1 {
    public static int giaiThua(int n){
        if(n == 0) return 1;

        return giaiThua(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(giaiThua(5));
    }
}
