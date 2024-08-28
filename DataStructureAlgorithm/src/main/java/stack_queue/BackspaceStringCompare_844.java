package stack_queue;

import java.util.Stack;

public class BackspaceStringCompare_844 {
    public boolean backspaceCompare(String s, String t) {
        return type(s).equals(type(t));
    }

    public String type(String s){
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '#'){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.add(c);
            }
        }
        StringBuilder ss = new StringBuilder();
        while(!stack.empty()){
            ss.append(stack.pop());
        }
        return ss.toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare_844 b = new BackspaceStringCompare_844();
        b.backspaceCompare("y#fo##f", "y#f#o##f");
    }
}
