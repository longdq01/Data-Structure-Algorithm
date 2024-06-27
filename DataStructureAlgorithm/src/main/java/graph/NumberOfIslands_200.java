package graph;

public class NumberOfIslands_200 {
    private static void traversal(char[][] grid, int i, int j){
        if(0 <= i && i < grid.length && 0 <= j && j < grid[i].length){
            if(grid[i][j] == '1'){
                grid[i][j] = '0';
                traversal(grid, i - 1, j);
                traversal(grid, i + 1, j);
                traversal(grid, i, j - 1);
                traversal(grid, i, j + 1);
            }
        }
    }
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    traversal(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
}
