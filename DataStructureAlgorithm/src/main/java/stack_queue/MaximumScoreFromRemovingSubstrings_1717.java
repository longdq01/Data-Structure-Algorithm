package stack_queue;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings_1717 {
    public int maximumGain(String s, int x, int y) {
        // cdbcbbaaabab
        // x > y => ab
        // y > x => ba
        Stack<Character> stack = new Stack<>();
        int n = s.length(), sum = 0;
        if(y > x){
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if(c == 'b'){
                    stack.push(c);
                } else if (c == 'a') {
                    if(!stack.isEmpty() && stack.peek() == 'b'){
                        stack.pop();
                        sum += y;
                    }else{
                        stack.push(c);
                    }
                } else {
                    // aaaabbb
                    int bCount = 0, aCount = 0;
                    while(!stack.isEmpty()){
                        char top = stack.pop();
                        if(top == 'b')
                            bCount++;
                        else
                            aCount++;
                    }
                    sum += (x * Math.min(aCount, bCount));
                }
            }
            int bCount = 0, aCount = 0;
            while(!stack.isEmpty()){
                char top = stack.pop();
                if(top == 'b')
                    bCount++;
                else
                    aCount++;
            }
            sum += (x * Math.min(aCount, bCount));
        }else{
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if(c == 'a'){
                    stack.push(c);
                } else if (c == 'b') {
                    if(!stack.isEmpty() && stack.peek() == 'a'){
                        stack.pop();
                        sum += x;
                    }else{
                        stack.push(c);
                    }
                } else {
                    // aaaabbb
                    int bCount = 0, aCount = 0;
                    while(!stack.isEmpty()){
                        char top = stack.pop();
                        if(top == 'b')
                            bCount++;
                        else
                            aCount++;
                    }
                    sum += (y * Math.min(aCount, bCount));
                }
            }
            int bCount = 0, aCount = 0;
            while(!stack.isEmpty()){
                char top = stack.pop();
                if(top == 'b')
                    bCount++;
                else
                    aCount++;
            }
            sum += (y * Math.min(aCount, bCount));
        }
        return sum;
    }
}
