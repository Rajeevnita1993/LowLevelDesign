package com.example.DesignTicTacToe;

// The second solution is interesting, but I question how practical it would be.
// Part of playing a game is seeing the board. You can't print out the current state of the
// board with the second solution, you only know if there is a winner.

// That's just how it is. Because most algorithms are about trade off, solution 2 saves time
// complexity but also lose something such as memory of the exact game board comparing to the
// other solution. You can find this kind trade off in many efficient algorithms too, those time
// complexity you save does not come from nowhere, they are trade by losing memory of data
public class TicTacToeGame {
    private int[] rows;
    private int[] cols;
    int diagonal;
    int antiDiagonal;
    private int n;

    public TicTacToeGame(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }

    // Time : O(1) because we are marking every row, column, diagonal and antiDiagonal in constant time
    // Space : O(n) as we use arrays of size n for rows and cols
    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? +1 : -1;

        rows[row] += currentPlayer;
        cols[col] += currentPlayer;

        if (row == col) {
            diagonal++;
        }

        if (col == n - row - 1) {
            antiDiagonal++;
        }

        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n ){
            return player;
        }

        return 0;

    }
}
