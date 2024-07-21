package com.example.array;

import java.lang.reflect.Array;
import java.util.*;

public class BuildaMatrixWithConditions_2392 {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        Graph rowGraph = new Graph(k);
        int[] rowTopoSorted = rowGraph.buildTopoArraySorted(rowConditions);
        if(rowTopoSorted.length == 0)
            return new int[0][0];

        Graph colGraph = new Graph(k);
        int[] colTopoSorted = colGraph.buildTopoArraySorted(colConditions);
        if(colTopoSorted.length == 0)
            return new int[0][0];

        HashMap<Integer, Integer> col = new HashMap<>();
        for (int i = 0; i < k; i++) {
            col.put(colTopoSorted[i], i);
        }

        for (int i = 0; i < k; i++) {
            int colIdx = col.get(rowTopoSorted[i]);
            matrix[i][colIdx] = rowTopoSorted[i];
        }

        return matrix;
    }

    class Graph{
        int k;
        List<Integer>[] adjacentVertex;
        public Graph(int k){
            this.k = k;
            adjacentVertex = new List[k + 1];
            for (int i = 1; i <= k; i++) {
                adjacentVertex[i] = new ArrayList<Integer>();
            }
        }

        public void addAdjacentVertex(int v1, int v2){
            this.adjacentVertex[v1].add(v2);
        }

        public int[] buildTopoArraySorted(int[][] conditions){
            for (int[] c: conditions){
                this.addAdjacentVertex(c[0], c[1]);
            }
            return this.topologicalSort();
        }

        public int[] topologicalSort(){
            Set<Integer> set = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            Set<Integer> checkIsCyclic = new HashSet<>();
            for (int i = 1; i <= k; i++) {
                if(!set.contains(i)){
                    boolean isCylic = topologicalSortUtil(i, set, stack, checkIsCyclic);
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

        private boolean topologicalSortUtil(int i, Set<Integer> set, Stack<Integer> stack, Set<Integer> checkIsCyclic){
            set.add(i);
            checkIsCyclic.add(i);
            List<Integer> adjacent = this.adjacentVertex[i];
            for (int v: adjacent) {
                if(checkIsCyclic.contains(v)){
                    return true;
                }

                if(!set.contains(v)){
                    if(topologicalSortUtil(v, set, stack, checkIsCyclic))
                        return true;
                }
            }
            stack.add(i);
            checkIsCyclic.remove(i);
            return false;
        }
    }

    public static void main(String[] args) {
        BuildaMatrixWithConditions_2392 b = new BuildaMatrixWithConditions_2392();
//        int[][] matrix = b.buildMatrix(3, new int[][]{{1,2},{3,2}}, new int[][]{{2,1},{3,2}});
        int[][] matrix = b.buildMatrix(8, new int[][]{{1,2},{7,3},{4,3},{5,8},{7,8},{8,2},{3,2},{1,3},{7,6},
        {7,4},{4,8},{7,5}}, new int[][]{{5,7},{2,7},{4,3},{6,7},{4,3},{2,3},{6,2}});
        System.out.println(Arrays.deepToString(matrix));
    }
}
