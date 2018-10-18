public class Board {

	private State[] boardState = new State[9];
	private State currentTurn;
	
	
	//Constructor, sets the board's state to all blank:
	public Board(){
		resetBoard();
	}

	// This method should be called when the user makes a move:
	public void move(int positionOnBoard) {

		// This line changes the state of the selected position on the board to
		// the value in the turn variable:
		boardState[positionOnBoard] = currentTurn;

		// This block flips the state of the turn variable for the next turn if
		// the game is not completed:
		if (!gameCompleted(currentTurn, positionOnBoard)) {
			if (currentTurn == State.O) {
				currentTurn = State.X;
			} else if (currentTurn == State.X) {
				currentTurn = State.O;
			}
		}

	}
	
	//This method takes a position and returns the string representation of the enum: 
	public String getString(int position){
		if (boardState[position] == State.X){
			return "x";
		} else if (boardState[position] == State.O){
			return "o";
		} else {
			return "";
		}
	}

	// This method should be called when the user begins a new game:
	public void resetBoard() {
		for (int i = 0; i < 9; i++) {
			boardState[i] = State.BLANK;
		}
	}

	/*
	 * The next method checks if the previous move completed the game, the cases
	 * represent the possible last move, and the if tests represent ways that
	 * there can be a line.
	 */
	private boolean gameCompleted(State lastMove, int position) {
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
			else
				return false;
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
			} else
				return false;
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
			else if (boardState[5] == lastMove) {
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
			} else
				return false;
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
			else if (boardState[2] == lastMove) {
				return true;
			}
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
			else if (boardState[1] == lastMove && boardState[7] == lastMove) {
				return true;
			}
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
		default:
			return false;
		}

	}
}
