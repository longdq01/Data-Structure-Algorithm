package twopointer;

public class ReverseString_344 {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while(i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++; j--;
        }
    }

    public static void main(String[] args) {

    }
}
