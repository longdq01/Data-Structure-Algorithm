package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merged = new ArrayList<>();
        int[] curInterval = intervals[0];
        int i = 0, j = 1, n = intervals.length;
        while(j < n){
            if(intervals[j][0] <= intervals[i][1]){
                curInterval[1] = Math.max(intervals[j][1],intervals[i][1]);
            }else{
                merged.add(curInterval);
                curInterval = intervals[j];
                i = j;
            }
            j++;
        }
        merged.add(curInterval);
        return merged.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{1,4},{0,4}})));
    }
}
