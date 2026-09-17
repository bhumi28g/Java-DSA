
import java.util.*;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, ans, n);

        return ans;
    }

    public void solve(int col, char[][] board,
                      List<List<String>> ans, int n) {
        if (col == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }
        for (int row = 0; row < n; row++) {

            if (isCorrect(board, row, col, n)) {

                board[row][col] = 'Q';

                solve(col + 1, board, ans, n);

                // Backtracking
                board[row][col] = '.';
            }
        }
    }
    public boolean isCorrect(char[][] board,
                             int row, int col, int n) {

        int dRow = row;
        int dCol = col;

        // Check upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        row = dRow;
        col = dCol;

        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        row = dRow;
        col = dCol;

        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        NQueens obj = new NQueens();

        List<List<String>> result = obj.solveNQueens(n);

        System.out.println("\nAll possible solutions:");

        if (result.isEmpty()) {
            System.out.println("No solution exists.");
        } else {
            int count = 1;

            for (List<String> board : result) {
                System.out.println("\nSolution " + count++ + ":");

                for (String row : board) {
                    System.out.println(row);
                }
            }

            System.out.println("\nTotal solutions: " + result.size());
        }

        sc.close();
    }
}