package com.example.admin.tictactoe;

class MiniMaxMiseryVersion {

    //    static String player = "o", opponent = "x";

   /*  public static void main(String[] args) {
        System.out.println("Hello world! We are running");
        String[][] board = { { "x", "o", "x" }, { "o", "o", "x" }, { "_", "_", "_" } };
        int bestMove = findBestMove(board);
        System.out.println("The Optimal Move is : " + bestMove);
    } */

    // Traverse all cells, evaluate minimax function for all empty cells. And return
    // the cell with optimal value.
    static int findBestMove(String[][] board) {
        //int bestMoveValue = -1000;
        int bestMovePositionRow = -1;
        int bestMovePositionCol = -1;
        int currentMoveValue = -1;
        int bestMoveValue = -1;
//		TwoDtoOneDArrayAdaptor oneDArrayAdaptor = new TwoDtoOneDArrayAdaptor(twoDBoard);
//		String[] board = oneDArrayAdaptor.getOneDArray();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("_")) {
                    // make move
                    board[i][j] = "x";
                    if (isMovesLeft(board) == false) {
                        bestMovePositionRow = i;
                        bestMovePositionCol = j;
                    }
                    // compute evaluation function for this move.
                    else if (!line(board)) {
                        boolean trap = true;
                        for (int x = 0; x < 3; x++) {
                            for (int y = 0; y < 3; y++) {
                                if (board[x][y].equals("_")) {
                                    board[x][y] = "x";
                                    if (!line(board))
                                        trap = false;
                                    board[x][y] = "_";
                                }
                            }
                        }
                        if (trap) {
                            return i * 3 + j;
                        }
                        else {
                            currentMoveValue = 1;
                        }
                    }
                    else {
                        currentMoveValue = 0;
                    }
                    // Undo the move
                    board[i][j] = "_";
                    if (currentMoveValue > bestMoveValue) {
                        bestMovePositionRow = i;
                        bestMovePositionCol = j;
                        bestMoveValue = currentMoveValue;
                    }
                }
            }
        }
        //System.out.println("The value of the best Move is :" + bestMovePositionRow + " " + bestMovePositionCol);
        // code converts 2d array to one d array--3 is col
        return bestMovePositionRow * 3 + bestMovePositionCol;
    }

    private static boolean line(String[][] board) {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals("x") && board[row][1].equals("x") && board[row][2].equals("x"))
                return true;
        }
        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals("x") && board[1][col].equals("x") && board[2][col].equals("x")) {
                return true;
            }
        }
        // Checking for Diagonals for X or O victory.
        if (board[0][0].equals("x") && board[1][1].equals("x") && board[2][2].equals("x")) {
            return true;
        }
        if (board[0][2].equals("x") && board[1][1].equals("x") && board[2][0].equals("x")) {
            return true;
        }
        // Else if none of them have won then return 0
        return false;
    }

    static boolean isMovesLeft(String board[][]) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].equals("_"))
                    return true;
        return false;
    }
}