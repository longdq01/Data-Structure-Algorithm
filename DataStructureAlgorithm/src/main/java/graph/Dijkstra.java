package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
    public static void dijkstra(int[][] a, int start, int end){
        Set<Integer> visisted = new HashSet<>();
        int n = a.length;
        int[] previous = new int[n];
        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        int cur = start;
        while(visisted.size() < n){
            visisted.add(cur);
            for (int i = 0; i < n; i++) {
                if(a[cur][i] != 0 && !visisted.contains(i)){
                    int tmp = distance[cur] + a[cur][i];
                    if(tmp < distance[i]){
                        distance[i] = tmp;
                        previous[i] = cur;
                    }
                }
            }

            int minVal = Integer.MAX_VALUE;
            cur = 0;
            for (int i = 0; i < n; i++){
                if(!visisted.contains(i) && distance[i] < minVal){
                    cur = i;
                    minVal = distance[i];
                }
            }
        }
        int p = end;
        while(p != start){
            System.out.print(p);
            System.out.print("<-");
            p = previous[p];
        }
        System.out.print(p);
    }

    public static void main(String[] args) {
        int[][] a = {
                {0, 6, 0, 1, 0},
                {6, 0, 5, 2, 2},
                {0, 5, 0, 0, 5},
                {1, 2, 0, 0, 1},
                {0, 2, 5, 1, 0}
        };

        dijkstra(a, 0, 2);
    }
}
