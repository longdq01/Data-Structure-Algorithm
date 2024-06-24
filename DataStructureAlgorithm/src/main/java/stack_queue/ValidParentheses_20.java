package stack_queue;

import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;
                char d = stack.pop();
                if((d == '(' &&  c != ')') || (d == '[' && c != ']') || (d == '{' && c != '}')){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
