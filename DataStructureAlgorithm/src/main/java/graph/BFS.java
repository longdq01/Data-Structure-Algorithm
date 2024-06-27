package graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BFS {
    public static void BFS(int[][] graph){
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.println(u);
            for (int i = 0; i < graph.length; i++) {
                if(graph[u][i] == 1 && !visited.contains(i)){
                    queue.add(i);
                    visited.add(i);
                }
            }
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

        BFS(graph);
    }
}
