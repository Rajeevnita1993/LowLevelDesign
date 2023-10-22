package com.example.DesignTicTacToe;

public class TicTacToe {

    private int[][] board;
    private int n;

    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
    }

    // Time : O(4*n) ~ O(n)
    // Space : O(n^2) as board contains n * n move
    public int move(int row, int col, int player) {
        board[row][col] = player;
        // check if the player wins
        if (checkRow(row, player) || checkColumn(col, player) || (row == col) && checkDiagonal(player)
                        || (col == n- row - 1) && checkAntiDiagonal(player)) {
            return player;
        }
        // No one wins
        return 0;
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) return false;
        }
        return true;
    }

    private boolean checkColumn(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) return false;
        }
        return true;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - row - 1] != player) return false;
        }
        return true;
    }
}
