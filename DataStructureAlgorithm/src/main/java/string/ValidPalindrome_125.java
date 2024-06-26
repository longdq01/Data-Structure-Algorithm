package string;

public class ValidPalindrome_125 {
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;

        while (l < r) {
            while(l < n && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(r >= 0 && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(l < r){
                if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                    return false;
                l++;
                r--;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
