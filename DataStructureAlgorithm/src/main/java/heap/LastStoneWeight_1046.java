package heap;

import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone: stones) {
            pq.add(stone);
        }

        while(!pq.isEmpty()){
            int x = pq.poll();
            if(pq.peek() == null)
                return x;

            int y = pq.poll();
            if(x > y)
                pq.add(x - y);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
