package string;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0, n = s.length(), m = t.length();
        while(i < n){
            while(j < m && t.charAt(j) != s.charAt(i)){
                j++;
            }
            if(j == m)
                return false;
            i++;
            j++;
        }
        return true;
    }
}
