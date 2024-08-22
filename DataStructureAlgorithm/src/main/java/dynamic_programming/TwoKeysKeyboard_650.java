package dynamic_programming;

public class TwoKeysKeyboard_650 {
    public int minSteps(int n) {
        if(n == 1)
            return 0;

        int sqrt = (int) Math.sqrt(n);
        int step = 0, v;
        for (int i = 2; i <= sqrt; i++) {
            v = 0;
            while(n % i == 0){
                n /= i;
                v++;
            }
            step += (i * v);
        }
        if(n > 1){
            step += n;
        }
        return step;
    }
}
