
public abstract class Player {
	
	protected boolean[][] validMoves;
	private boolean didForfeitTurn = false;
	private String pieceIdentifier = "";
	private String className = "";
// ____________________________________________________________________________________________
	
	/**
	 * Chooses a position on the board to place a player piece
	 * @param board the board to be referenced with a row/col position
	 */
	public abstract void chooseMove(ReversiBoard board); 
// ____________________________________________________________________________________________
	
	/**
	 * Determines if player has any moves left.
	 * @return true if player has valid move remaining
	 */
	public abstract boolean hasValidMoveLeft(); 
	
// ____________________________________________________________________________________________///
// ____________________________________________________________________________________________///
// ______________________________________GETTERS/SETTERS BELOW THIS____________________________///
// ____________________________________________________________________________________________///
// ____________________________________________________________________________________________///
	
	/**
	 * Gets validMoves array
	 * @return boolean[][] the validMoves array
	 */
	public boolean[][] getValidMovesArray() {
		return this.validMoves;
	}
// ____________________________________________________________________________________________
	
	/**
	 * Sets validMoves array.
	 */
	public void setValidMovesArray(boolean[][] moves) {
		this.validMoves = moves;
	}
// ____________________________________________________________________________________________
	
	/**
	 * Gets didForfeitTurn field.
	 * @return boolean the didForfeitTurn field
	 */
	public boolean getDidForfeitTurn() {
		return this.didForfeitTurn;
	}
// ____________________________________________________________________________________________	
	
	/**
	 * Sets didForfeitTurn field.
	 * @param value the true/false value assigned to the didForfeitTurn field
	 */
	public void setDidForfeitTurn(boolean value) {
		this.didForfeitTurn = value;
	}
// ____________________________________________________________________________________________
	
	/**
	 * Gets pieceIdentifier field.
	 * @return String the pieceIdentifier field
	 */
	public String getPieceIdentifier() {
		return this.pieceIdentifier;
	}
// ____________________________________________________________________________________________
	
	/**
	 * Sets the pieceIdentifier field.
	 * @param id the identifier of the piece, either "X " or "O ". X's always go first in Reversi.
	 */
	public void setPieceIdentifier(String id) {
		if(id.equals("X ") || id.equals("O ")) {
			this.pieceIdentifier = id;
		}
	}
// ____________________________________________________________________________________________
	
	/**
	 * Gets className field
	 */
	public String getClassName() {
		return this.className;
	}
// ____________________________________________________________________________________________
	
	/**
	 * Sets the className field
	 * @param name the name of the class
	 */
	public void setClassName(String name) {
		this.className = name;
	}
	
	
} // Player
