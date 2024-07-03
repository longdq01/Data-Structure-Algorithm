package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestRepeatingCharacterReplacement_424 {
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length(), maxLen = Integer.MIN_VALUE;
        int l = 0, r = 0, mostFreqChar = 0;
        while(r < n){
            char c = s.charAt(r);
            int counting = map.getOrDefault(c, 0) + 1;
            mostFreqChar = Math.max(mostFreqChar, counting);
            map.put(c, counting);
            if(r - l + 1 - mostFreqChar > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
