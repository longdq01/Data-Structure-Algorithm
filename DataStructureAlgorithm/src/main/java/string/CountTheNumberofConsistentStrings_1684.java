package string;

public class CountTheNumberofConsistentStrings_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] allowedChars = new int[26];
        for(int i = 0; i < allowed.length(); i++) {
            allowedChars[allowed.charAt(i) - 'a'] = 1;
        }

        int count = 0;
        for(String word: words){
            if(isConsistent(word, allowedChars))
                count++;
        }
        return count;
    }

    public boolean isConsistent(String word, int[] allowedChars) {
        for (int i = 0; i < word.length(); i++) {
            if(allowedChars[word.charAt(i) - 'a'] == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CountTheNumberofConsistentStrings_1684 c = new CountTheNumberofConsistentStrings_1684();
        c.countConsistentStrings("ab", new String[]{"ad","bd","aaab","baa","badab"});
    }
}
