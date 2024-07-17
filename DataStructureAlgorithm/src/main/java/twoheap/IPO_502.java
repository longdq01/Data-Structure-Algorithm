package twoheap;

import java.util.Collections;
import java.util.PriorityQueue;

public class IPO_502 {
    class Project{
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Project> minHeap = new PriorityQueue<>((o1, o2) -> o1.capital - o2.capital);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            minHeap.add(new Project(capital[i], profits[i]));
        }

        int sumOfCapitals = w, project = 0;
        while(project < k){
            while(!minHeap.isEmpty() && minHeap.peek().capital <= sumOfCapitals){
                maxHeap.add(minHeap.poll().profit);
            }

            if(maxHeap.isEmpty()){
                break;
            }

            sumOfCapitals += maxHeap.poll();
            project++;
        }

        return sumOfCapitals;
    }
}
