package slowandfast;

public class HappyNumber {
    public static boolean isHappyNumber(int n) {
        int s = sumOfSquareDigits(n);
        int slow = s, fast = sumOfSquareDigits(s);
        while(slow != 1){
            if(slow == fast)
                return false;
            slow = sumOfSquareDigits(slow);
            fast = sumOfSquareDigits(sumOfSquareDigits(fast));
        }
        return true;
    }

    private static int sumOfSquareDigits(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(2));
    }
}
