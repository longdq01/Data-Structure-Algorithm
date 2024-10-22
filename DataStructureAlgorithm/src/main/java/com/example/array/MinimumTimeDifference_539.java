package com.example.array;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeDifference_539 {
    public static int findMinDifference(List<String> timePoints) {
        timePoints.sort((o1, o2) -> {
            String[] time1 = o1.split(":");
            String[] time2 = o2.split(":");
            int hour1 = Integer.parseInt(time1[0]), hour2 = Integer.parseInt(time2[0]);
            int min1 = Integer.parseInt(time1[1]), min2 = Integer.parseInt(time2[1]);

            if (hour1 == hour2)
                return Integer.compare(min1, min2);
            return Integer.compare(hour1, hour2);
        });
        String[] time0 = timePoints.get(0).split(":");
        timePoints.add(Integer.parseInt(time0[0]) + 24 + ":" + Integer.parseInt(time0[1]));

        String[] timelast = timePoints.get(0).split(":");
        timePoints.add(0, Integer.parseInt(timelast[0]) - 24 + ":" + Integer.parseInt(timelast[1]));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            String[] time1 = timePoints.get(i).split(":");
            String[] time2 = timePoints.get(i + 1).split(":");
            int hour1 = Integer.parseInt(time1[0]), hour2 = Integer.parseInt(time2[0]);
            int min1 = Integer.parseInt(time1[1]), min2 = Integer.parseInt(time2[1]);
            int dif = (hour2 - hour1) * 60 + (min2 - min1);
            min = Math.min(min, dif);
        }
        return min;
    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<String>();
        timePoints.add("00:00");
        timePoints.add("23:40");
        timePoints.add("23:20");
        timePoints.add("05:15");

        System.out.println(findMinDifference(timePoints));
    }
}
