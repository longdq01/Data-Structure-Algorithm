package top_k_elements;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentElements_347 {
    class Freq{
        int val;
        int freq;

        public Freq(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num: nums){
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Freq> minHeap = new PriorityQueue<>((o1, o2) -> o1.freq - o2.freq);
        for(int num: frequency.keySet()){
            minHeap.add(new Freq(num, frequency.get(num)));
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] results = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            results[i++] = minHeap.poll().val;
        }
        return results;
    }
}
