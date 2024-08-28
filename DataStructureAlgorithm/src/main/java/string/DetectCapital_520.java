package string;

public class DetectCapital_520 {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int s = 0;
        for (int i = 0; i < n; i++) {
            if(Character.isUpperCase(word.charAt(i)))
                s += 1;
        }
        return s == n || s == 0 || (Character.isUpperCase(word.charAt(0)) && s == 1);
    }
}
