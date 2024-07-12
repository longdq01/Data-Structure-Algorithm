package stack_queue;

import java.util.Stack;

public class CrawlerLogFolder_1598 {
    public int minOperations(String[] logs) {
        int count = 0;
        for(String log: logs){
            if (log.equals("../")) {
                if(count > 0)
                    count--;
            }else if(!log.equals("./")){
                count++;
            }
        }
        return count;
    }
}
