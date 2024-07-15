package twoheap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian_480 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

    public void addNum(int num) {
        if(maxHeap.isEmpty() && minHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }

        if(maxHeap.isEmpty()){
            maxHeap.add(minHeap.poll());
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
            return (double) ((long) maxHeap.peek() + minHeap.peek()) / 2;
    }

    private void rebalance(){
        if(maxHeap.size() - 1 > minHeap.size()){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() - 1 > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public void removeNum(int num){
//        if(num > maxHeap.peek()){
//            minHeap.remove(num);
//        }else{
//            maxHeap.remove(num);
//        }
        boolean deleted = minHeap.remove(num);
        if(!deleted)
            maxHeap.remove(num);
        // re-balance
        rebalance();
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] medians = new double[n - k + 1];
        int i = 0, j = 0;
        for (;j < k; j++) {
            addNum(nums[j]);
        }
        medians[i] = findMedian();
        while(j < n){
            removeNum(nums[i]);
            addNum(nums[j]);
            i++;
            medians[i] = findMedian();
            j++;
        }
        return medians;
    }

    public static void main(String[] args) {
        String fileName = "E:\\Long\\workspace\\Data-Structure-Algorithm\\DataStructureAlgorithm\\src\\main\\java\\twoheap\\arr.txt";

        // Tạo ArrayList để lưu các phần tử tạm thời
        List<Integer> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Tách các phần tử được ngăn cách bởi dấu phẩy
                String[] values = line.split(",");
                for (String value : values) {
                    list.add(Integer.parseInt(value.trim())); // trim() để loại bỏ khoảng trắng dư thừa
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Chuyển ArrayList sang mảng
        int[] array = list.stream().mapToInt(i -> i).toArray();
        SlidingWindowMedian_480 s = new SlidingWindowMedian_480();
        System.out.println(Arrays.toString(s.medianSlidingWindow(array, 50000)));
    }
}
