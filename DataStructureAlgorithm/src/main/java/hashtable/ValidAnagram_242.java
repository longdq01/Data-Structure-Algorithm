package hashtable;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        int n = s.length(), m = t.length();
        for (int i = 0; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            tCount[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(sCount[i] != tCount[i])
                return false;
        }
        return true;
    }
}
