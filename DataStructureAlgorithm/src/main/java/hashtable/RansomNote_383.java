package hashtable;

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomCount = new int[26];
        int[] magazineCount = new int[26];
        int n = ransomNote.length(), m = magazine.length();
        for (int i = 0; i < n; i++) {
            ransomCount[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            magazineCount[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(ransomCount[i] > magazineCount[i])
                return false;
        }
        return true;
    }
}
