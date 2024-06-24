package stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberofStudentsUnabletoEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();

        int idx = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i] == sandwiches[idx]){
                idx++;
            }else{
                queue.add(students[i]);
            }
        }

        int size = queue.size();
        int attemp = 0;
        while(true){
            if(size == 0) return 0;

            Integer c = queue.poll();
            if(c != null && c == sandwiches[idx]){
                idx++;
                attemp = 0;
                size--;
            }else{
                queue.add(c);
                attemp++;
            }

            if(attemp == size){
                return size;
            }
        }
    }
}
