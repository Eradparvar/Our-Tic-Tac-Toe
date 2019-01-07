package com.example.admin.tictactoe;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

public class Board {

	private State[] boardState = new State[9];
	private State currentTurn;
	private Context context;
	private  Activity activity;
	private int turns = 0;
	private boolean tieGame;
	private int lastMove;
	private State lastState = State.BLANK;
	private boolean gameCompleted = false;
	private boolean misereVersion = false;
	private boolean copy;
    Handler handler = new Handler();
	
	
	//Constructor, sets the board's state to all blank:
	Board(State firstTurn, Context context, Activity activity){
	    currentTurn = firstTurn;
        this.context = context;
        this.activity = activity;
		resetBoard();
		copy = false;
	}


	String[][] getTwoDimensionalStringArrayRepresentingBoardState(){
		String[][] arrayToReturn = new String[3][3];
		for (int i = 0; i < boardState.length; i++){
			if (i < 3){
				arrayToReturn[0][i] = getStringRepresentationOfState(boardState[i]);
			} else if (i < 6){
				arrayToReturn[1][i - 3] = getStringRepresentationOfState(boardState[i]);
			} else {
				arrayToReturn[2][i - 6] = getStringRepresentationOfState(boardState[i]);
			}
		}
		return arrayToReturn;
	}

	String getStringRepresentationOfState(State s1){
		if (s1 == State.BLANK){
			return "_";
		} else if (s1 == State.O){
			return "o";
		} else {
			return "x";
		}
	}

	// This method should be called when the user makes a move:
	public void move(int positionOnBoard) {

        turns++;
		// This line changes the state of the selected position on the board to
		// the value in the turn variable:
		boardState[positionOnBoard] = currentTurn;
		lastMove = positionOnBoard;
		lastState = currentTurn;

		//Check if game completed:
		if (gameCompleted(currentTurn, positionOnBoard, this.boardState)) {
			gameCompleted = true;
			winnerDisplayAlertDialog();
			return;
		}
		else if(turns == 9) {
			tieGame = true;
			gameCompleted = true;
			winnerDisplayAlertDialog();
			return;
		}
		
		// This block flips the state of the turn variable for the next turn:
		if (!misereVersion){
			flip();
		}
		

	}

	//This method flips the turn at the end of a move:
	void flip(){
		if (currentTurn == State.O) {
			currentTurn = State.X;
		} else if (currentTurn == State.X) {
			currentTurn = State.O;
		}
	}
	void undoMove() {
		boardState[lastMove] = State.BLANK;
		currentTurn = lastState;
		turns--;
	}

	void restGui() {
		activity.setContentView(R.layout.activity_main);

	}

	void setMisereVersion(){
		misereVersion = true;
	}

	public void turnOffMisereVersion(){
		misereVersion = false;
	}

	public boolean tie(){
		return gameCompleted() && tieGame;
	}

	private void winnerDisplayAlertDialog() {
		if(MainActivity.miseryVersion || MainActivity.miseryVersionCPU) {
			new AlertDialog.Builder(context)
					.setTitle("Game Over")
					.setMessage(turns % 2 == 0 ? "Player 2 Loses!" : "Player 1 Loses!" )
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							restGui();
							resetBoard();
							dialog.cancel();
						}
					}).show();
		}
		else {
			new AlertDialog.Builder(context)
					.setTitle("Game Over")
					.setMessage(tieGame ? "Tie Game" : currentTurn + " Wins!")
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							restGui();
							resetBoard();
							dialog.cancel();
						}
					}).show();
		}
    }



	State getStateAt(int index){
		return boardState[index];
	}

	//This method takes a position and returns the string representation of the enum: 
    String getString(int position){
		if (boardState[position] == State.X){
			return "x";
		} else if (boardState[position] == State.O){
			return "o";
		} else {
			return "";
		}
	}

	// This method should be called when the user begins a new game:
    void resetBoard() {
		for (int i = 0; i < 9; i++) {
			boardState[i] = State.BLANK;
		}
		currentTurn = State.X;
		turns = 0;
		tieGame = false;
	}

	public State[] getBoardStateArray(){
		return boardState;
	}

	State getCurrentTurn(){
		return currentTurn;
	}
	int getTurns(){ return turns; }

	boolean gameCompleted(){
		return gameCompleted;
	}

	void newGame(){
		gameCompleted = false;
	}


	/*
	 * The next method checks if the previous move completed the game, the cases
	 * represent the possible last move, and the if tests represent ways that
	 * there can be a line.
	 */
    private boolean gameCompleted(State lastMove, int position, State[] boardState) {
		switch (position) {
		case 0:
			/*-
			 * The following condition tests for a line on the top row:
			 * 		-------------
			 * 		| * | * | * |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		|   |   |   |
			 *		-------------
			 */
			if (boardState[1] == lastMove && boardState[2] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line along the left side:
			 * 		-------------
			 *		| * |   |   |
			 *		-------------
			 * 		| * |   |   |
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 */
			else if (boardState[3] == lastMove && boardState[6] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a diagonal line (top,left to bottom,right): 
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 */
			else if (boardState[4] == lastMove && boardState[8] == lastMove) {
				return true;
			}
			// In any other case the last move did not complete the game:
			break;
		case 1:
			/*-
			 * The following condition tests for a line across the top: 
			 * 		-------------
			 * 		| * | * | * |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 */
			if (boardState[0] == lastMove && boardState[2] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line down the middle: 
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 */
			else if (boardState[4] == lastMove && boardState[7] == lastMove) {
				return true;
			}
			break;
		case 2:
			/*-
			 * The following condition tests for a line across the top: 
			 * 		-------------
			 * 		| * | * | * |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 */
			if (boardState[0] == lastMove && boardState[1] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line down the right side: 
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 */
			else if (boardState[5] == lastMove && boardState[8] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a diagonal (top,right to bottom,left): 
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 */
			else if (boardState[4] == lastMove && boardState[6] == lastMove) {
				return true;
			}
			break;
		case 3:
			/*-
			 * The following condition tests for a line down the left: 
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 */
			if (boardState[0] == lastMove && boardState[6] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line across the middle:
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		| * | * | * |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 */
			else if (boardState[4] == lastMove && boardState[5] == lastMove) {
				return true;
			}
			break;
		case 4:
			/*-
			 * The following condition tests for a line down the center:
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 */
			if (boardState[1] == lastMove && boardState[7] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line across the middle:
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		| * | * | * |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 */
			else if (boardState[3] == lastMove && boardState[5] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a diagonal (top,left to bottom,right):
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 */
			else if (boardState[0] == lastMove && boardState[8] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a diagonal (top,right to bottom,left):
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 */
			else if (boardState[2] == lastMove && boardState[6] == lastMove) {
				return true;
			}
			break;
		case 5:
			/*-
			 * The following condition tests for a line down the right side:
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 */
			if (boardState[2] == lastMove && boardState[8] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line across the middle:
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		| * | * | * |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 */
			if (boardState[3] == lastMove && boardState[4] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line down the right:
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 */
			else if (boardState[2] == lastMove && boardState[8] == lastMove) {
				return true;
			}
			break;
		case 6:
			/*-
			 * The following condition tests for a line down the left:
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 */
			if (boardState[0] == lastMove && boardState[3] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line across the bottom:
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		| * | * | * |
			 * 		-------------
			 */
			else if (boardState[7] == lastMove && boardState[8] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a diagonal line (bottom,left to top,right):
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 */
			else if (boardState[2] == lastMove && boardState[4] == lastMove) {
				return true;
			}
			break;
		case 7:
			/*-
			 * The following condition tests for a line across the bottom:
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		| * | * | * |
			 * 		-------------
			 */
			if (boardState[6] == lastMove && boardState[8] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line down the middle:
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 */
			else if (boardState[1] == lastMove && boardState[4] == lastMove) {
				return true;
			}
			break;
		case 8:
			/*-
			 * The following condition tests for a line across the bottom:
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		|   |   |   |
			 * 		-------------
			 * 		| * | * | * |
			 * 		-------------
			 */
			if (boardState[6] == lastMove && boardState[7] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a line down the right side:
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 */
			else if (boardState[2] == lastMove && boardState[5] == lastMove) {
				return true;
			}
			/*-
			 * The following condition tests for a diagonal:
			 * 		-------------
			 * 		| * |   |   |
			 * 		-------------
			 * 		|   | * |   |
			 * 		-------------
			 * 		|   |   | * |
			 * 		-------------
			 */
			else if (boardState[0] == lastMove && boardState[4] == lastMove) {
				return true;
			}
			break;
		default:
			return false;
		}
        return false;
    }
}
