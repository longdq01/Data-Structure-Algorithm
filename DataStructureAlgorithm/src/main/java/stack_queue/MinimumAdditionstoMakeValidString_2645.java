package stack_queue;

import java.util.Stack;

public class MinimumAdditionstoMakeValidString_2645 {
    public static int addMinimum(String word) {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if(c == 'a'){
                if(!stack.isEmpty()){
                    if(stack.pop() == 'b'){
                        count += 1;
                    }else{
                        count += 2;
                    }
                    stack.clear();
                }
                stack.push(c);
            }else if(c == 'b'){
                if(!stack.isEmpty()){
                    char tmp = stack.pop();
                    if(tmp == 'b'){
                        count += 2;
                        stack.clear();
                        stack.push(c);
                    }else if(tmp == 'a'){
                        stack.clear();
                        stack.push(c);
                    }
                }else{
                    count += 1;
                    stack.push(c);
                }
            }else if(c == 'c'){
                if(stack.isEmpty()){
                    count += 2;
                }else if(stack.peek() == 'a'){
                    count += 1;
                }
                stack.clear();
            }
        }

        if(!stack.isEmpty()){
            char tmp = stack.pop();
            if(tmp == 'a'){
                count += 2;
            }else if(tmp == 'b'){
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(addMinimum("b"));
    }
}
