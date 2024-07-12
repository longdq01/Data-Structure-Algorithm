package stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath_71 {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int n = path.length();
        stack.push("");
        for (int i = 0; i < n; i++) {
            char c = path.charAt(i);
            if(c == '/'){
                String tmp = sb.toString();
                if(tmp.equals("..")){
                    stack.pop();
                    if(stack.isEmpty()){
                        stack.push("");
                    }
                } else if(!tmp.isEmpty() && !tmp.equals(".")){
                    stack.push(sb.toString());
                }
                sb = new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        String tmp = sb.toString();
        if(tmp.equals("..")){
            stack.pop();
            if(stack.isEmpty()){
                stack.push("");
            }
        } else if(!tmp.isEmpty() && !tmp.equals(".")){
            stack.push(sb.toString());
        }
        String result = String.join("/", stack);
        return result.isEmpty() ? "/" : result;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }
}
