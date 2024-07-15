package twoheap;

import java.util.PriorityQueue;

public class FindMedianfromDataStream_295 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public FindMedianfromDataStream_295() {

    }

    public void addNum(int num) {
        if(minHeap.isEmpty() && maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }

        if(num > maxHeap.peek()){
            minHeap.add(num);
        }else{
            maxHeap.add(num);
        }
        // re-balance
        rebalance();
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else if(maxHeap.size() < minHeap.size())
            return minHeap.peek();
        else
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }

    private void rebalance(){
        if(maxHeap.size() - 1 > minHeap.size()){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() - 1 > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public void removeNum(int num){
        if(num > maxHeap.peek()){
            minHeap.remove(num);
        }else{
            maxHeap.remove(num);
        }

        // re-balance
        rebalance();
    }
}
