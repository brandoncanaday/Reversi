
public class RandomComputerPlayer extends ComputerPlayer {
	
	/**
	 * Creates RandomComputerPlayer with desired piece identifier
	 * @param id the identifier of the piece, either "X " or "O ". X's always go first in Reversi. 
	 */
	public RandomComputerPlayer(String id) {
		setPieceIdentifier(id);
		setClassName("RandomComputerPlayer");
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
	 * Chooses random position from the valid positions contained in the validMoves array and places the computer's piece
	 * at that position.
	 * @param board the board to be referenced with the chosen position
	 */
	public void chooseMove(ReversiBoard board) {
		
		System.out.print("Enter your move, " + getPieceIdentifier() + "player: ");
		
		java.util.Random numGen = new java.util.Random();
		int countMin = 20; // chose a number that would, without a doubt, always be greater than the number of validMoves
		int countMax = numGen.nextInt(30) + countMin; // the random number that validMoveCount must reach before the loop stops
		
		int validMoveCount = 0;
		while(validMoveCount <= countMax) {
			for(int i = 0; i < validMoves.length; i++) {
				for(int j = 0; j < validMoves[i].length; j++) {
					if(validMoves[i][j]) {
						validMoveCount++;
						if(validMoveCount == countMax) {
							createTimeDelay(3000); // pauses execution for 3 seconds
							System.out.print((i+1) + " " + (j+1)); // adding 1 takes into account the board doesn't start at 0,0
							System.out.println("\n");
							board.updateBoard(i, j, this);
							board.clearUnderscores();
							return;
						}
					}
				}
			}
		} /* basically like spinning the wheel on wheel of fortune. what it lands on is essentially random, 
			 and the pegs the arrow contacts on the way around represent the validMoveCount incrementing */
	}
	
}
