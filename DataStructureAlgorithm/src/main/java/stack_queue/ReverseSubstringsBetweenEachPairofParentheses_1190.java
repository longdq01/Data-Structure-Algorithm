package stack_queue;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses_1190 {
    public String reverseParentheses(String s) {
        StringBuilder tmp = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(tmp.toString());
                tmp = new StringBuilder();
            }else if(c == ')'){
                String rev = new StringBuilder(tmp).reverse().toString();
                String top = stack.pop();
                tmp = new StringBuilder(top + rev);
            }else{
                tmp.append(c);
            }
        }
        return tmp.toString();
    }
}
