package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyHeap {
    private final int MAX_SIZE = 100;
    private int[] arr = new int[MAX_SIZE + 1];
    private int size;

    public MyHeap() {
        size = 0;
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public int peek(){
        if(!isEmpty()){
            return arr[1];
        }
        // throw exception
        return -1;
    }

    public void add(int v){
        arr[++size] = v;
        int curIdx = size, parentIdx = curIdx / 2;
        while(curIdx > 0 && arr[curIdx] < arr[parentIdx]){
            int tmp = arr[curIdx];
            arr[curIdx] = arr[parentIdx];
            arr[parentIdx] = tmp;
            curIdx = parentIdx;
            parentIdx = curIdx / 2;
        }
    }

    public int poll(){
        if(isEmpty()){
            // throw exception
            return -1;
        }
        int root = arr[1];
        arr[1] = arr[size];
        size--;
        // heapify down
        heapifyDown(1);

        return root;
    }

    private void heapifyDown(int curIdx){
        int leftIdx = 2 * curIdx;

        while(leftIdx <= size){
            int minValIdx = leftIdx;
            int rightIdx = leftIdx + 1;
            if(rightIdx <= size && arr[rightIdx] < arr[leftIdx]){
                minValIdx = rightIdx;
            }

            if(arr[curIdx] > arr[minValIdx]){
                int tmp = arr[curIdx];
                arr[curIdx] = arr[minValIdx];
                arr[minValIdx] = tmp;
                curIdx = minValIdx;
                leftIdx = 2 * curIdx;
            }else{
                break;
            }
        }
    }

    public void remove(int v){
        int curIdx = -1;
        for (int i = 1; i <= size; i++) {
            if(arr[i] == v){
                curIdx = i;
                break;
            }
        }

        if(curIdx == -1)
            return;

        arr[curIdx] = arr[size];
        size--;
        // heapify down
        heapifyDown(curIdx);
    }

    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(100);
        minHeap.add(20);
        minHeap.add(3);
        minHeap.add(7);
        minHeap.add(2);
        minHeap.add(5);

        while(!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }
}
