
public interface Board {
	
	/**
	 * Prints out the current state of the board.
	 */
	public void printBoard();
// _____________________________________________________________________________________
	
	/**
	 * Updates state of board with new player piece
	 * @param r the row of the board the player's piece was placed on
	 * @param c the col of the board the player's piece was placed on
	 * @param p the type of player placing the piece
	 */
	public void updateBoard(int row, int col, Player p);
// _____________________________________________________________________________________
	
	/**
	 * Determines if board is full of pieces or not.
	 * @return true if board is full
	 */
	public boolean isFull();
// _____________________________________________________________________________________

	
} // Board


