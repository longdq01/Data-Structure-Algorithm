package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TheNumberoftheSmallestUnoccupiedChair_1942 {
    static class Pair{
        int idx;
        int leaveTime;

        public Pair(int idx, int leaveTime){
            this.idx = idx;
            this.leaveTime = leaveTime;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (o1, o2) -> times[o1][0] - times[o2][0]);

        HashMap<Integer, Integer> map = new HashMap<>(); // friend thứ i, số ghế
        int chair = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((o1, o2) -> o1.leaveTime - o2.leaveTime);
        for (int i: order) {
            int arrival = times[i][0], leave = times[i][1];
            if(!minHeap.isEmpty() && arrival >= minHeap.peek().leaveTime){
                int idx = minHeap.poll().idx;
                map.put(i, map.get(idx));
            }else{
                map.put(i,chair++);
            }
            minHeap.add(new Pair(i, leave));
        }

        return map.get(targetFriend);
    }

    public static void main(String[] args) {
        TheNumberoftheSmallestUnoccupiedChair_1942 t = new TheNumberoftheSmallestUnoccupiedChair_1942();
        t.smallestChair(new int[][]{{1,4},{2,3},{4,6}}, 1);
    }
}
