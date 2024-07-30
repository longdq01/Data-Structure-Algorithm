package graph;

import java.util.*;

public class FindCityWithSmallestNumberOfNeighborsThresholdDistance_1334 {
    HashMap<Integer, List<Edge>> adjacent = new HashMap<>();
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        initGraph(n, edges);
        int[] counting = new int[n];
        for (int i = 0; i < n; i++) {
            counting[i] = dijkstraCountNeighbors(i, n, distanceThreshold);
        }
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if(counting[minIdx] >= counting[i]){
                minIdx = i;
            }
        }
        return minIdx;
    }

    public int dijkstraCountNeighbors(int v, int n, int k){
        Set<Integer> visited = new HashSet<>();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[v] = 0;
        int count = 0;
        while(true){
            visited.add(v);
            for (Edge edge: adjacent.get(v)) {
                if(!visited.contains(edge.to) && (dp[v] + edge.weight < dp[edge.to])){
                    dp[edge.to] = dp[v] + edge.weight;
                }
            }
            int min = Integer.MAX_VALUE, minIdx = -1;
            for (int i = 0; i < n; i++) {
                if(!visited.contains(i) && min > dp[i]){
                    min = dp[i];
                    minIdx = i;
                }
            }
            if(minIdx == -1)
                break;
            v = minIdx;
            if(min <= k)
                count++;
        }
        return count;
    }

    public void initGraph(int n, int[][] edges){
        for (int i = 0; i < n; i++) {
            adjacent.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            addEdge(edge[0], edge[1], edge[2]);
            addEdge(edge[1], edge[0], edge[2]);
        }
    }

    public void addEdge(int from, int to, int weight){
        List<Edge> adjacentEdge = adjacent.get(from);
        adjacentEdge.add(new Edge(from, to, weight));
        adjacent.put(from, adjacentEdge);
    }

    class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        FindCityWithSmallestNumberOfNeighborsThresholdDistance_1334 f = new FindCityWithSmallestNumberOfNeighborsThresholdDistance_1334();
        System.out.println(f.findTheCity(6, new int[][]{{0,3,7},{2,4,1},{0,1,5},{2,3,1},{1,3,6},{1,2,1}}, 417));
    }
}
