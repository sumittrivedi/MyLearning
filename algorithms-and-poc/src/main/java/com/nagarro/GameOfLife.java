package com.nagarro;

public class GameOfLife {
    public static void main(String[] args) {

    }

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int deadToLive = -1;
        int liveToDead = 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveCells = 0;
                if ((i > 0 && j > 0) && board[i - 1][j - 1] >= 1) {
                    liveCells++;
                }

                if (i > 0 && board[i - 1][j] >= 1) {
                    liveCells++;
                }

                if ((i > 0 && j < col - 1) && board[i - 1][j + 1] >= 1) {
                    liveCells++;
                }

                if (j > 0 && board[i][j - 1] >= 1) {
                    liveCells++;
                }

                if (j < col - 1 && board[i][j + 1] >= 1) {
                    liveCells++;
                }

                if ((i < row - 1 && j > 0) && board[i + 1][j - 1] >= 1) {
                    liveCells++;
                }

                if (i < row - 1 && board[i + 1][j] >= 1) {
                    liveCells++;
                }

                if ((i < row - 1 && j < col - 1) && board[i + 1][j + 1] >= 1) {
                    liveCells++;
                }

                if (board[i][j] == 0 && liveCells == 3) {
                    board[i][j] = deadToLive;
                }
                if (board[i][j] == 1 && (liveCells < 2 || liveCells > 3)) {
                    board[i][j] = liveToDead;
                }

            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == liveToDead)
                    board[i][j] = 0;
                if (board[i][j] == deadToLive)
                    board[i][j] = 1;
            }
        }
    }
}
