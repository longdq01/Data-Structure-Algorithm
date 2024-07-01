package slidingwindow;

import java.util.*;

public class RepeatedDNASequences_187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> results = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int j = 10, n = s.length();
        if(j >= n){
            return results;
        }
        String substr = s.substring(0, j);
        map.put(substr, 1);
        while(j < n){
            substr = new StringBuilder(substr).deleteCharAt(0).append(s.charAt(j)).toString();
            int count = map.getOrDefault(substr, 0);
            if(count == 1){
                results.add(substr);
            }
            map.put(substr, count + 1);
            j++;
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
