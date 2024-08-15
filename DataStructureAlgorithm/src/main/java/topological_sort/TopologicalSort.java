package topological_sort;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
    public int[] topologicalSort(int k, List<Integer>[] adjacentVertex){
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> checkIsCyclic = new HashSet<>();
        for (int i = 1; i <= k; i++) {
            if(!set.contains(i)){
                boolean isCylic = topologicalSortUtil(i, set, stack, checkIsCyclic, adjacentVertex);
                if(isCylic){
                    return new int[]{};
                }
            }
        }
        int[] topoSort = new int[k];
        int i = 0;
        while(!stack.isEmpty()){
            topoSort[i++] = stack.pop();
        }
        return topoSort;
    }

    private boolean topologicalSortUtil(int i, Set<Integer> set, Stack<Integer> stack, Set<Integer> checkIsCyclic, List<Integer>[] adjacentVertex){
        set.add(i);
        checkIsCyclic.add(i);
        List<Integer> adjacent = adjacentVertex[i];
        for (int v: adjacent) {
            if(checkIsCyclic.contains(v)){
                return true;
            }

            if(!set.contains(v)){
                if(topologicalSortUtil(v, set, stack, checkIsCyclic, adjacentVertex))
                    return true;
            }
        }
        stack.add(i);
        checkIsCyclic.remove(i);
        return false;
    }
}
