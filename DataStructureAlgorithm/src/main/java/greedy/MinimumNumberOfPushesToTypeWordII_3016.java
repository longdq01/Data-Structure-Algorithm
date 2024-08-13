package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumNumberOfPushesToTypeWordII_3016 {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> freq = new HashMap<>();
        List<Character> arr = new ArrayList<>();

        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            Integer f = freq.get(c);
            if(f == null){
                arr.add(c);
                freq.put(c, 1);
            }else{
                freq.put(c, f + 1);
            }
        }

        arr.sort((o1, o2) -> freq.get(o2) - freq.get(o1));
        n = arr.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (int) Math.ceil((i + 1) / 8d) * freq.get(arr.get(i));
        }
        return res;
    }
}
