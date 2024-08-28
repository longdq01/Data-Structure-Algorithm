package graph;

public class CountSubIslands_1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if(grid2[i][j] == 1){
                    count += traversal(grid2, grid1, i, j, 1);
                }
            }
        }
        return count;
    }

    public int traversal(int[][] grid, int[][] parent, int i, int j, int c){
        if(0 <= i && i < grid.length && 0 <= j && j < grid[i].length){
            if(grid[i][j] == 1){
                if(parent[i][j] != 1)
                    c = 0;
                grid[i][j] = 0;
                c *= traversal(grid, parent, i - 1, j, c);
                c *= traversal(grid, parent, i + 1, j, c);
                c *= traversal(grid, parent, i, j - 1, c);
                c *= traversal(grid, parent, i, j + 1, c);
                return c;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        CountSubIslands_1905 c = new CountSubIslands_1905();
        int[][] grid1 = new int[][]{
                {1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}
        };
        int[][] grid2 = new int[][]{
                {1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}
        };
        c.countSubIslands(grid1, grid2);
    }
}
