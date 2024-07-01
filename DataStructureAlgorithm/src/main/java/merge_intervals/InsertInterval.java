package merge_intervals;


import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval {
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        LinkedList<int[]> merged = new LinkedList<>();
        int start = newInterval[0], end = newInterval[1];
        int n = existingIntervals.length;
        int i = 0;
        while(i < n && existingIntervals[i][1] < start){
            merged.add(existingIntervals[i]);
            i++;
        }
        if(i < n && existingIntervals[i][0] < start){
            merged.add(new int[]{existingIntervals[i][0], Math.max(existingIntervals[i][1], end)});
            i++;
        }else{
            merged.add(newInterval);
        }
        while (i < n) {
            int[] lastMerged = merged.getLast();
            if(existingIntervals[i][0] <= lastMerged[1]){
                lastMerged[1] = Math.max(lastMerged[1], existingIntervals[i][1]);
            }else{
                merged.add(existingIntervals[i]);
            }
            i++;
        }

        return merged.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insertInterval(new int[][]{{1, 3}, {4, 5}, {7, 8}, {9, 12}, {13, 14}},
                new int[]{2, 10})));
    }
}
