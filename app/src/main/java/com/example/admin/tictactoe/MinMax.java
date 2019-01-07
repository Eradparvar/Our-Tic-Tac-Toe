package com.example.admin.tictactoe;



class MinMax {

    private static String player = "o", opponent = "x";

  /*  public static void main(String[] args) {
        System.out.println("Hello world! We are running");
        String[][] board = { { "x", "o", "x" }, { "o", "o", "x" }, { "_", "_", "_" } };
        int bestMove = findBestMove(board);
        System.out.println("The Optimal Move is : " + bestMove);
    } */

    // Traverse all cells, evaluate minimax function for all empty cells. And return
    // the cell with optimal value.
    static int findBestMove(String[][] board) {
        int bestMoveValue = -1000;
        int bestMovePositionRow = -1;
        int bestMovePositionCol = -1;
//		TwoDtoOneDArrayAdaptor oneDArrayAdaptor = new TwoDtoOneDArrayAdaptor(twoDBoard);
//		String[] board = oneDArrayAdaptor.getOneDArray();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("_")) {
                    // make move
                    board[i][j] = player;
                    // compute evaluation function for this move.
                    int currentMoveValue = miniMax(board, 0, false);
                    // Undo the move
                    board[i][j] = "_";
                    // If the value of the currentMoveValue is greater than the bestMoveValue, then
                    // update
                    // best
                    if (currentMoveValue > bestMoveValue) {
                        bestMovePositionRow = i;
                        bestMovePositionCol = j;
                        bestMoveValue = currentMoveValue;
                    }
                }
            }
        }
        System.out.println("The value of the best Move is :" + bestMovePositionRow + " " + bestMovePositionCol);
        // code converts 2d array to one d array--3 is col
        return bestMovePositionRow * 3 + bestMovePositionCol;
    }

    static int evaluate(String[][] board) {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])) {
                if (board[row][0].equals(player))
                    return +10;
                else if (board[row][0].equals(opponent))
                    return -10;
            }
        }
        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals(board[1][col]) && board[1][col].equals(board[2][col])) {
                if (board[0][col].equals(player))
                    return +10;
                else if (board[0][col].equals(opponent))
                    return -10;
            }
        }
        // Checking for Diagonals for X or O victory.
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            if (board[0][0].equals(player))
                return +10;
            else if (board[0][0].equals(opponent))
                return -10;
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            if (board[0][2].equals(player))
                return +10;
            else if (board[0][2].equals(opponent))
                return -10;
        }
        // Else if none of them have won then return 0
        return 0;
    }

    static boolean isMovesLeft(String board[][]) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].equals("_"))
                    return true;
        return false;
    }

    static int miniMax(String[][] board, int depth, boolean isMax) {
        int score = evaluate(board);
        // If Maximizer has won the game return his/her
        // evaluated score
        if (score == 10)
            return score;
        // If Minimizer has won the game return his/her
        // evaluated score
        if (score == -10)
            return score;
        // If there are no more moves and no winner then
        // it is a tie
        if (isMovesLeft(board) == false)
            return 0;
        // If this maximizer's move
        if (isMax) {
            int best = -1000;
            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (board[i][j].equals("_")) {
                        // Make the move
                        board[i][j] = player;
                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, miniMax(board, depth + 1, !isMax));
                        // Undo the move
                        board[i][j] = "_";
                    }
                }
            }
            return best;
        }
        // If this minimizer's move
        else {
            int best = 1000;
            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (board[i][j].equals("_")) {
                        // Make the move
                        board[i][j] = opponent;
                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, miniMax(board, depth + 1, !isMax));
                        // Undo the move
                        board[i][j] = "_";
                    }
                }
            }
            return best;
        }
    }
}
