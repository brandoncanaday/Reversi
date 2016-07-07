
public class IntelligentComputerPlayer extends ComputerPlayer {

	protected static int[][] pointsForEachMove;
	protected static boolean intelligentExecute = false;
	
	/**
	 * Creates IntelligentComputerPlayer with desired piece identifier
	 * @param id the identifier of the piece, either "X " or "O ". X's always go first in Reversi. 
	 */
	public IntelligentComputerPlayer(String id) {
		setPieceIdentifier(id);
		setClassName("IntelligentComputerPlayer");
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
	 * Chooses best position from the valid positions contained in the validMoves array and places the computer's piece
	 * at that position.
	 * @param board the board to be referenced with the chosen position
	 */
	public void chooseMove(ReversiBoard board) {
		
		System.out.print("Enter your move, " + getPieceIdentifier() + "player: ");
		
		setPointPossibilities(board);
		determineBestMove(board);
		
	}
//______________________________________________________________________________________________________________
	
	/**
	 * Uses the updateBoard method, not to place a piece/flip pieces, but to update the pointsForEachMove array with the values
	 * for each potential valid move
	 * @param board the board to be referenced 
	 */
	private void setPointPossibilities(ReversiBoard board) {
		
		pointsForEachMove = new int[board.getBoard().length][board.getBoard()[0].length];
		
		for(int r=0; r<board.getBoard().length; r++) {
			for(int c=0; c<board.getBoard()[r].length; c++) {
				intelligentExecute=true; // prevent update board from updating the pieces 
				board.updateBoard(r, c, this); // uses updateBoard to udpate an array of points for each possible flip for
											   // intelligent computer, instead of actually placing a piece
			} // for
		} // for
		board.clearUnderscores();
		intelligentExecute=false; // allows updateBoard to be able to actually place a piece

	} // setPointPossibilities
//______________________________________________________________________________________________________________
	
	/**
	 * Using the pointsForEachMove array, this chooses the highest point move out of all the valid moves, and if there is a tie 
	 * for the highest value, randomly chooses between the tie, and then places the piece at the chosen space.
	 * @param board the board to be referenced
	 */
	private void determineBestMove(ReversiBoard board) {
		
		int intellectualPrevious=0;
		int intellectualRow=0;
		int intellectualCol=0;
		
		for(int i=0; i<board.getBoard().length; i++) {
			for(int j=0; j<board.getBoard()[i].length; j++) {
				
				if(pointsForEachMove[i][j]>=intellectualPrevious) {
					intellectualPrevious=pointsForEachMove[i][j];
					intellectualRow=i;
					intellectualCol=j;
				} // if
				
			} // for
		} // for
		
		
		/* if there is more than one move which has the highest point total, this code chooses randomly between them. this way, the last move with the highest
		 * point total isn’t always the one chosen. Note: if this were the case, all games between 2 IntelligentComputerPlayer’s would be the exact same.
		 */
		java.util.Random numGen = new java.util.Random();
		int countMin = 20; // chose a number that would, without a doubt, always be greater than the number of validMoves
		int countMax = numGen.nextInt(30) + countMin; // the random number that validMoveCount must reach before the loop stops
		int highestPointMoveCount = 0;
		while(highestPointMoveCount <= countMax) {
			for(int i=0; i<board.getBoard().length; i++) {
				for(int j=0; j<board.getBoard()[i].length; j++) {
					if(pointsForEachMove[i][j]==pointsForEachMove[intellectualRow][intellectualCol]) { // find the tie of the highest possible point
						highestPointMoveCount++;
						if(highestPointMoveCount == countMax) {
							createTimeDelay(3000); // pauses execution for 3 seconds
							System.out.print((i+1) + " " + (j+1)); // adding 1 takes into account the board doesn't start at 0,0
							System.out.println("\n");
							board.updateBoard(i, j, this);
						}
					} //if
				} //for
			} //for
		} //while
		
	} // chooseBestMove
	
}
