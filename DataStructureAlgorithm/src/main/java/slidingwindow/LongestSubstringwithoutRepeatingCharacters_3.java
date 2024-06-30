package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        int size = 0, max = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                size++;
            }else{
                size = Math.min(i - map.get(c), size + 1);
            }
            map.put(c, i);
            max = Math.max(size, max);
        }

        return max;
    }
}
