package stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberofRecentCalls_933 {
    private Queue<Integer> queue;
    public NumberofRecentCalls_933() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        int threshold = t - 3000;
        Integer val = queue.peek();
        while(val != null && val < threshold){
            queue.remove();
            val = queue.peek();
        }
        return queue.size();
    }
}
