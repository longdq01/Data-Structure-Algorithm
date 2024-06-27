package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
//    public static void DFS(int[][] graph){
//        Stack<Integer> stack = new Stack<>();
//        Set<Integer> visited = new HashSet<>();
//
//        stack.add(0);
//        visited.add(0);
//        while(!stack.isEmpty()){
//            int u = stack.pop();
//            System.out.println(u);
//            for (int i = 0; i < graph.length; i++) {
//                if(graph[u][i] == 1 && !visited.contains(i)){
//                    stack.push(i);
//                    visited.add(i);
//                }
//            }
//        }
//    }
    static Set<Integer> visisted = new HashSet<>();
    public static void DFS(int[][] graph, int u){
        visisted.add(u);
        System.out.println(u);
        for (int i = 0; i < graph.length; i++) {
            if(graph[u][i] == 1 && !visisted.contains(i))
                DFS(graph, i);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 1, 0 ,0, 0},
                {0, 0, 0, 1, 1, 0, 0}
        };

        DFS(graph, 0);
    }
}
