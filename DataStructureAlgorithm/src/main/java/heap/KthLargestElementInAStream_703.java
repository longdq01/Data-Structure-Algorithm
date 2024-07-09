package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargestElementInAStream_703 {
    List<Integer> heap = new ArrayList<>();
    int currentSize = 0;
    int k;

    public KthLargestElementInAStream_703(int k, int[] nums) {
        this.k = k;
        for (int num: nums){
            addToHeap(num);
        }
    }

    public int add(int val) {
        addToHeap(val);
        List<Integer> list = new ArrayList<>();
        int level = (int) Math.log(k) + 1;
        for (int i = (int) (Math.pow(2, level - 1) - 1); i < (int) (Math.pow(2, level) - 1); i++) {
            list.add(heap.get(i));
        }
        list.sort((o1, o2) -> o2 - o1);
        return list.get(k - (int) Math.pow(2, level - 1));
    }

    public void addToHeap(int val){
        heap.add(val);
        currentSize++;
        int currentIdx = currentSize - 1;
        while(currentIdx > 0 && heap.get(currentIdx) > heap.get(currentIdx / 2)){
            int tmp = heap.get(currentIdx);
            heap.set(currentIdx, heap.get(currentIdx / 2));
            heap.set(currentIdx / 2, tmp);
            currentIdx /= 2;
        }
    }

    public static void main(String[] args) {
        KthLargestElementInAStream_703 k = new KthLargestElementInAStream_703(3, new int[]{5,4,8,2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));

    }
}
