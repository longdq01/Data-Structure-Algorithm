package backtracking;

public class WordSearch_79 {
    int n, m;
    int[][] v;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        v = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                v[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(backtracking(i, j, board, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtracking(int i, int j, char[][] board, String word, int idx){
        v[i][j] = 1;
        if(board[i][j] == word.charAt(idx)){
            if(idx == word.length() - 1){
                return true;
            }
        }else{
            v[i][j] = 0;
            return false;
        }
        boolean exist;
        if(i + 1 < n && v[i + 1][j] == 0){
            exist = backtracking(i + 1, j, board, word, idx + 1);
            if(exist)
                return exist;
        }
        if(i - 1 >= 0 && v[i - 1][j] == 0){
            exist = backtracking(i - 1, j, board, word, idx + 1);
            if(exist)
                return exist;
        }
        if(j + 1 < m && v[i][j + 1] == 0){
            exist = backtracking(i, j + 1, board, word, idx + 1);
            if(exist)
                return exist;
        }
        if(j - 1 >= 0 && v[i][j - 1] == 0){
            exist = backtracking(i, j - 1, board, word, idx + 1);
            if(exist)
                return exist;
        }
        v[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        WordSearch_79 w = new WordSearch_79();
        System.out.println(w.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));
    }
}
