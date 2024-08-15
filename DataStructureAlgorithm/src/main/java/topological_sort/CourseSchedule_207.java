package topological_sort;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule_207 {
    // [ai, bi] => bi -> ai
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cyclic = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            if(!visited.contains(i)){
                if(!topologicalSort(i, prerequisites)){
                    return false;
                }
            }
        }
        return true;
    }

    // return false if prerequisites is cyclic graph
    public boolean topologicalSort(int i, int[][] prerequisites){
        visited.add(i);
        cyclic.add(i);
        for (int[] pre: prerequisites) {
            if(pre[1] == i){
                if(cyclic.contains(pre[0]))
                    return false;

                if(!visited.contains(pre[0]))
                    if(!topologicalSort(pre[0], prerequisites))
                        return false;
            }
        }
        stack.add(i);
        cyclic.remove(i);
        return true;
    }
}
