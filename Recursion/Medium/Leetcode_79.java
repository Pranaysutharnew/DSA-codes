package Recursion.Medium;

public class Leetcode_79 {
//    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//    Output: true
//    Example 2:
//    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//    Output: true
//    Example 3:
//    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//    Output: false
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
    static int[][] direction = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static int m;
    static int n;
    public static boolean exist(char[][] board, String word) {
         m = board.length;
         n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean find(char[][] board, int i, int j, int idx, String word){
        if (idx == word.length())
            return true;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#'){
            return false;
        }
        if (board[i][j] != word.charAt(idx)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';

        for (int[] dir : direction) {
            int di = i + dir[0];
            int dj = j + dir[1];

            if (find(board, di, dj, idx + 1, word)){
                return true;
            }
        }
            board[i][j] = temp;
        return false;
    }
}
