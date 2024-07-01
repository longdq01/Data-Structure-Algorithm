package slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubsequence {
    public static String minWindow(String s, String t) {
        int j = 0, n1 = s.length(), n2 = t.length();
        String result = "";
        for (int i = 0; i < n1; i++) {
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }

            if(j == n2){
                int k = i - 1;
                j -= 2;
                StringBuilder sb = new StringBuilder();
                sb.insert(0, s.charAt(i));
                while(j >= 0){
                    sb.insert(0, s.charAt(k));
                    if(s.charAt(k) == t.charAt(j)){
                        j--;
                    }
                    k--;
                }
                if(result.isEmpty() || result.length() > sb.length()){
                    result = sb.toString();
                }
                j = 0;
                i = k + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("abcdbebe", "bbe"));
    }
}
