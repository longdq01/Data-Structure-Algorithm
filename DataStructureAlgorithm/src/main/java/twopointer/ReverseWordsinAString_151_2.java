package twopointer;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsinAString_151_2 {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = n, j = n - 1;
        while(true){
            while(j >= 0 && s.charAt(j) != ' '){
                j--;
            }
            String tmp = s.substring(j + 1, i);
            if(!tmp.isEmpty()){
                sb.append(tmp);
                sb.append(" ");
            }
            if(j < 0){
                break;
            }
            i = j;
            j--;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
