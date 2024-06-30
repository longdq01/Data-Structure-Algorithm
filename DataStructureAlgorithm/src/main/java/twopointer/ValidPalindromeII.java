package twopointer;

public class ValidPalindromeII {
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1, count = 0;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                if(count == 1)
                    return false;
                if(s.charAt(l) == s.charAt(r-1)){
                    count++;
                    r-=2;
                    l++;
                }else if(s.charAt(l+1) == s.charAt(r)){
                    count++;
                    l+=2;
                    r--;
                }else
                    return false;
            }else{
                l++;
                r--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("RACEACAT"));
    }
}
