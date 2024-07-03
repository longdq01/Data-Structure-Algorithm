package slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring_76 {
    static HashMap<Character, Integer> freq = new HashMap<>();
    static HashMap<Character, Integer> freqWindow = new HashMap<>();
    public static String minWindow(String s, String t) {
        initFreqMap(t);
        int l = 0, r = 0, req = freq.size(), res = 0, n = s.length();
        int minLen = Integer.MAX_VALUE, lIdx = -1, rIdx = -1;
        while(l < n && r < n){
            char c = s.charAt(r);
            if(freq.containsKey(c)){
                int counting = freqWindow.getOrDefault(c, 0) + 1;
                freqWindow.put(c, counting);
                if(counting == freq.get(c))
                    res++;
                while(l < n && req == res){
                    int tmpLen = r - l + 1;
                    if(minLen > tmpLen){
                        minLen = tmpLen;
                        lIdx = l;
                        rIdx = r;
                    }
                    char trimChar = s.charAt(l);
                    if(freq.containsKey(trimChar)){
                        int countingTmp = freqWindow.get(trimChar) - 1;
                        freqWindow.put(trimChar, countingTmp);
                        if(countingTmp < freq.get(trimChar)){
                            res--;
                        }
                    }
                    l++;
                }
                r++;
            }else{
                r++;
            }
        }
        if(lIdx == -1 || rIdx == -1)
            return "";
        return s.substring(lIdx, rIdx + 1);
    }

    private static void initFreqMap(String t){
        int s = t.length();
        for (int i = 0; i < s; i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }
}
