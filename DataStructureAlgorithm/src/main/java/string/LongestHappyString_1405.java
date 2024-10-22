package string;

import java.util.Collections;
import java.util.PriorityQueue;

public class LongestHappyString_1405 {
    static class Pair{
        char c;
        int nums;

        Pair(char c, int nums){
            this.c = c;
            this.nums = nums;
        }
    }

    private void addToHeap(char c, int nums, PriorityQueue<Pair> heap){
        if(nums > 0){
            heap.add(new Pair(c, nums));
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(Collections.reverseOrder());
        addToHeap('a', a, maxHeap);
        addToHeap('b', b, maxHeap);
        addToHeap('c', c, maxHeap);
        Pair tmp;
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Pair top = maxHeap.poll();
            if(top.nums >= 2){
                sb.append(top.c);
                sb.append(top.c);
                top.nums -= 2;
            }else{
                sb.append(top.c);
                top.nums--;
            }
            tmp = top;
        }
        return sb.toString();
    }
}
