package greedy;

import java.util.ArrayList;
import java.util.List;

public class MaximumSwap_670 {
    public int maximumSwap(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        while(num > 0){
            digits.add(0, num%10);
            num /= 10;
        }
        int n = digits.size();
        List<Integer> descDigits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            descDigits.add(i);
        }
        descDigits.sort((o1, o2) -> digits.get(o2) - digits.get(o1));

        for (int i = 0; i < n; i++) {
            if(digits.get(i) < digits.get(descDigits.get(i))){
                int j = i;
                while(j < n && digits.get(descDigits.get(i)) == digits.get(descDigits.get(j))){
                    j++;
                }
                j--;
                int tmp = digits.get(i);
                digits.set(i, digits.get(descDigits.get(j)));
                digits.set(descDigits.get(j), tmp);
                break;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res * 10 + digits.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSwap_670 obj = new MaximumSwap_670();
        obj.maximumSwap(1993);
    }
}
