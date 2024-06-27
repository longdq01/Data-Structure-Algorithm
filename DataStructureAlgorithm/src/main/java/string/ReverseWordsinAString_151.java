package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsinAString_151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> arr = new ArrayList<>();
        int i = 0, n = s.length();
        while(i < n){
            char c = s.charAt(i);
            if(c == ' '){
                if(!sb.isEmpty()){
                    arr.add(sb.toString());
                    sb = new StringBuilder();
                }
            }else{
                sb.append(c);
            }
            i++;
        }
        if(!sb.isEmpty()){
            arr.add(sb.toString());
        }
        int m = arr.size();
        sb = new StringBuilder();
        for (int j = m - 1; j >= 0; j--) {
            sb.append(arr.get(j));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
