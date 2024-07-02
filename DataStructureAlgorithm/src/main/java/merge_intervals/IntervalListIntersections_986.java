package merge_intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class IntervalListIntersections_986 {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        LinkedList<int[]> output = new LinkedList<>();

        int i = 0, j = 0, n1 = firstList.length, n2 = secondList.length;
        while(i < n1 && j < n2){
            int firstStart = firstList[i][0], firstEnd = firstList[i][1];
            int secondStart = secondList[j][0], secondEnd = secondList[j][1];
            int start = Math.max(firstStart, secondStart);
            int end = 0;
            if(firstEnd < secondEnd){
                end = firstEnd;
                i++;
            }else{
                end = secondEnd;
                j++;
            }
            if(start <= end){
                output.add(new int[]{start, end});
            }
        }


        return output.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(intervalIntersection(
                new int[][]{{2, 6}, {7, 9}, {10, 13}, {14, 19}},
                new int[][]{{1, 4}, {6, 8}, {15, 18}}
        )));
    }
}
