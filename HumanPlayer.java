public class HumanPlayer extends Player {
	
	/**
	 * Creates HumanPlayer with desired piece identifier
	 * @param id the identifier of the piece, either "X " or "O ". X's always go first in Reversi. 
	 */
	public HumanPlayer(String id) {
		setPieceIdentifier(id);
		setClassName("HumanPlayer");
	} // constructor
//______________________________________________________________________________________________________________
	
	public boolean hasValidMoveLeft() {
		boolean hasValidMove = false;
		for(int i = 0; i < validMoves.length; i++) {
			for(int j = 0; j < validMoves[i].length; j++) {
				if(validMoves[i][j]) {
					hasValidMove = true;
				}
			}
		}
		return hasValidMove;
	}
//______________________________________________________________________________________________________________
	
	/**
	 * Takes a row and col input from the human user and, if valid, places the user's piece at the specified position on the
	 * board.
	 * @param board the board to be referenced with the row/col position
	 */
	public void chooseMove(ReversiBoard board) {
		java.util.Scanner keyboard = new java.util.Scanner(System.in);
		boolean isValidInput = false;
		String input;
		do {
			System.out.print("Enter your move, " + getPieceIdentifier() + "player: ");
			input = keyboard.nextLine().trim();
			System.out.println();
			if(input.length() == 3 && input.charAt(1) == ' ') {
				java.util.Scanner keyboardTwo = new java.util.Scanner(input);
				if(keyboardTwo.hasNextInt()) {
					int row = keyboardTwo.nextInt() - 1; // takes into account that reversi does start indices at 0
					if(keyboardTwo.hasNextInt()) {
						int col = keyboardTwo.nextInt() - 1; // takes into account that reversi does start indices at 0
						if(row < board.getBoard().length && col < board.getBoard()[0].length && row >= 0 && col >= 0) {
							if(validMoves[row][col]) {
 								board.updateBoard(row, col, this);
								board.clearUnderscores();
								isValidInput = true;
							}
						}
					}
				}
			} 
			if(!isValidInput) {
				System.out.println();
				System.out.println("Please enter a valid move.");
				System.out.println();
				board.printBoard();
			}
		} while(!isValidInput);
	}
	
} // HumanPlayer
