package twoheap;

import java.util.ArrayList;
import java.util.List;

public class ScheduleTasksOnMinimumMachines {
    public int tasks(List<List<Integer>> tasksList) {
        tasksList.sort((o1, o2) -> {
            int dif = o1.get(0) - o2.get(0);
            if(dif == 0)
                return o1.get(1) - o2.get(1);
            return dif;
        });
        List<List<Integer>> count = new ArrayList<>();
        count.add(tasksList.get(0));

        for (int j = 1; j < tasksList.size(); j++){
            List<Integer> task = tasksList.get(j);
            int i = 0;
            while(i < count.size()){
                if(!overlapTask(count.get(i), task)){
                    count.set(i, task);
                    break;
                }
                i++;
            }
            if(i == count.size())
                count.add(task);
        }

        return count.size();
    }

    private boolean overlapTask(List<Integer> task1, List<Integer> task2){
        // t2Start >= t1Start
        int t1Start = task1.get(0), t1End = task1.get(1);
        int t2Start = task2.get(0), t2End = task2.get(1);

        return t2Start < t1End;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(List.of(12,13));
        list.add(List.of(13,15));
        list.add(List.of(17,20));
        list.add(List.of(13,14));
        list.add(List.of(19,21));
        list.add(List.of(18,20));

       ScheduleTasksOnMinimumMachines s = new ScheduleTasksOnMinimumMachines();
       System.out.println(s.tasks(list));
    }
}
