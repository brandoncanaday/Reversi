
public class ReversiBoard implements Board {
	
		private final int row = 8;
		private final int col = 8;
		private String [][] board = new String[row][col];
// ________________________________________________________________________________________________________	
	
		/**
		 * Constructor.
		 */
		public ReversiBoard() {
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					board[i][j] = ". ";
				}
			}
			board[3][3] = "X ";
			board[3][4] = "O ";
			board[4][3] = "O ";
			board[4][4] = "X ";
		}
		
// ________________________________________________________________________________________________________
		
		public void printBoard() {
			for(int i=0; i<row; i++) {
				if(i==0) {
					for(int k=0; k<row; k++ ) {
						if(k==0) {
							System.out.print("    " + (k+1));
						} //if
						else {
							System.out.print(" " + (k+1));
						} //else
					} //for
					System.out.println();
				}
				System.out.print("  " + (i+1) + " ");
				for(int j=0; j<col; j++) {
					System.out.print(board[i][j]);
				} //for
				System.out.println();
			} //for
			System.out.println();
		} //printBoard

// ________________________________________________________________________________________________________
		
		public void updateBoard(int r, int c, Player p) {
		
			//Determines which player turn
			String oppositePiece="", playerPiece="";
			if(p.getPieceIdentifier().equals("X ")) {
				oppositePiece = "O ";
				playerPiece = "X ";
			} else {
				oppositePiece = "X ";
				playerPiece = "O ";
			}
			
			
			int intelligentPieces = 0; // counts the number of potential flipped pieces for the intelligent computer's move
			
			//Locate the player piece
			int locatePiece=0;
			if(board[r][c].equals("_ ") || p.getValidMovesArray()[r][c]) { 
				if(!IntelligentComputerPlayer.intelligentExecute) {
					board[r][c]=playerPiece;
				} //if
				locatePiece=1;
			} //if
			
			
			if(locatePiece==1) {
			
				//Checks to the right horizontally
				int checkPiece=0, checkStop=1, otherPiece=0, flipPieces=0, endFlip=0, checkSkip=0;
				for(int i=c+1; i<col; i++) {	
					if(!board[r][i].equals(oppositePiece)) {
						checkSkip=1; //skip the check in that direction since no flips are available
					} //if
					if(board[r][i].equals(oppositePiece) && checkSkip==0) {
						if(checkStop==1) {
							for(int j=i; j<col; j++) {
								if(board[r][j].equals(oppositePiece)) {
									checkPiece=1; //possibly a valid direction to flip pieces
									endFlip++; //used to reiterate the amount of pieces to flip
									continue;
								} //if
								if(board[r][j].equals(". ") || board[r][j].equals("_ ") || (j==col-1 && board[r][j].equals(oppositePiece))){							
									otherPiece=1; //used to identify wrong pieces to not flip the pieces in that direction
									endFlip=0; //eliminate all the pieces to flip since invalid direction
								} //if
								if(board[r][j].equals(playerPiece) && checkPiece==1 && otherPiece!=1) {
									flipPieces=1; //confirms it's a valid direction to flip the pieces
									checkStop=0; //stop the checking of the pieces since the valid flip check is complete
									break;
								} //if
							} //for
						} //if 
						if(flipPieces==1 && board[r][i].equals(oppositePiece) && endFlip>0) {
							if(!IntelligentComputerPlayer.intelligentExecute) {
								board[r][i]=(playerPiece);
							} //if
							endFlip--; //used to stop the pieces from being flipped
							intelligentPieces++; //keep tracks of the flips to determine move for the intelligent computer
							continue;
						} //if
						else if(board[r][i].equals(playerPiece)) {
							break;
						} //else if
					} //if
				} //for

				
				//Checks to the left horizontally
				//comments above are all the same for the different check directions below
				int checkPieceTwo=0, checkStopTwo=1, otherPieceTwo=0, flipPiecesTwo=0, endFlipTwo=0, checkSkipTwo=0;
				for(int i=c-1; i>=0; i--) {	
					if(!board[r][i].equals(oppositePiece)) {
						checkSkipTwo=1;
					} //if
					if(board[r][i].equals(oppositePiece) && checkSkipTwo==0) {
						if(checkStopTwo==1) {
							for(int j=i; j>=0; j--) {
								if(board[r][j].equals(oppositePiece)) {
									checkPieceTwo=1;
									endFlipTwo++; 
									continue;
								} //if
								if(board[r][j].equals(". ") || board[r][j].equals("_ ") || (j==0 && board[r][j].equals(oppositePiece))){
									otherPieceTwo=1;
									endFlipTwo=0;
									break;
								} //if
								if(board[r][j].equals(playerPiece) && checkPieceTwo==1 && otherPieceTwo!=1) {
									flipPiecesTwo=1;
									checkStopTwo=0;
									break;
								} //if
							} //for
						} //if 
						if(flipPiecesTwo==1 && board[r][i].equals(oppositePiece) && endFlipTwo>0) {
							if(!IntelligentComputerPlayer.intelligentExecute) {
								board[r][i]=(playerPiece);
							} //if
							endFlipTwo--;
							intelligentPieces++;
							continue;
						} //if
						else if(board[r][i].equals(playerPiece)) {
							break;
						} //else if				
					} //if				
				} //for
				
				
				//Checks down vertically
				//comments above are all the same for the different check directions below
				int checkPieceThree=0, checkStopThree=1, otherPieceThree=0, flipPiecesThree=0, endFlipThree=0, checkSkipThree=0;
				for(int i=r+1; i<row; i++) {
					if(!board[i][c].equals(oppositePiece)) {
						checkSkipThree=1;
					} //if
					if(board[i][c].equals(oppositePiece) && checkSkipThree==0) {
						if(checkStopThree==1) {
							for(int j=i; j<row; j++) {
								if(board[j][c].equals(oppositePiece)) {
									checkPieceThree=1;
									endFlipThree++;
									continue;
								} //if
								if(board[j][c].equals(". ") || board[j][c].equals("_ ") || (j==row-1 && board[j][c].equals(oppositePiece))){
									otherPieceThree=1;
									endFlip=0;
									break;
								} //if
								if(board[j][c].equals(playerPiece) && checkPieceThree==1 && otherPieceThree!=1) {
									flipPiecesThree=1;
									checkStopThree=0;
									break;
								} //if
							} //for
						} //if 
						if(flipPiecesThree==1 && board[i][c].equals(oppositePiece) && endFlipThree>0) {
							if(!IntelligentComputerPlayer.intelligentExecute) {
								board[i][c]=(playerPiece);
							} //if
							endFlipThree--;
							intelligentPieces++;
							continue;
						} //if
						else if(board[i][c].equals(playerPiece)) {
							break;
						} //else if				
					} //if					
				} //for
				
						
				//Checks up vertically
				//comments above are all the same for the different check directions below
				int checkPieceFour=0, checkStopFour=1, otherPieceFour=0, flipPiecesFour=0, endFlipFour=0, checkSkipFour=0;
				for(int i=r-1; i>=0; i--) {
					if(!board[i][c].equals(oppositePiece)) {
						checkSkipFour=1;
					} //if
					if(board[i][c].equals(oppositePiece) && checkSkipFour==0) {
						if(checkStopFour==1) {
							for(int j=i; j>=0; j--) {
								if(board[j][c].equals(oppositePiece) && otherPieceFour==0) {
									checkPieceFour=1;
									endFlipFour++;
									continue;
								} //if
								if((board[j][c].equals(". ") ||  board[j][c].equals("_ ")) || (j==0 && board[j][c].equals(oppositePiece))){
									otherPieceFour=1;
									endFlipFour=0;
									break;
								} //if
								if(board[j][c].equals(playerPiece) && checkPieceFour==1 && otherPieceFour!=1) {
									flipPiecesFour=1;
									checkStopFour=0;
									break;
								} //if
							} //for
						} //if 
						if(flipPiecesFour==1 && board[i][c].equals(oppositePiece) && endFlipFour>0) {
							if(!IntelligentComputerPlayer.intelligentExecute) {
								board[i][c]=(playerPiece);
							} //if
							endFlipFour--;
							intelligentPieces++;
							continue;
						} //if
						else if(board[i][c].equals(playerPiece)) {
							break;
						} //else if				
					} //if					
				} //for

					
				//Checks to the upper left diagonally
				//comments above are all the same for the different check directions below
				int checkPieceFive=0, checkStopFive=1, otherPieceFive=0, flipPiecesFive=0, endFlipFive=0, checkSkipFive=0;
				for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--) {
					if(!board[i][j].equals(oppositePiece)) {
						checkSkipFive=1;
					} //if
					if(board[i][j].equals(oppositePiece) && checkSkipFive==0) {
						if(checkStopFive==1) {
							for(int k=i, l=j; k>=0 && l>=0; k--, l--) {
								if(board[k][l].equals(oppositePiece)) {
									checkPieceFive=1;
									endFlipFive++;
									continue;
								} //if
								if(board[k][l].equals(". ") || board[k][l].equals("_ ") || ((k==0 && j==0) && board[k][l].equals(oppositePiece))){
									otherPieceFive=1;
									endFlipFive=0;
									break;
								} //if
								if(board[k][l].equals(playerPiece) && checkPieceFive==1 && otherPieceFive!=1) {
									flipPiecesFive=1;
									checkStopFive=0;
									break;
								} //if
							} //for
						} //if 
						if(flipPiecesFive==1 && board[i][j].equals(oppositePiece) && endFlipFive>0) {
							if(!IntelligentComputerPlayer.intelligentExecute) {
								board[i][j]=(playerPiece);
							} //if
							endFlipFive--;
							intelligentPieces++;
							continue;
						} //if
						else if(board[i][j].equals(playerPiece)) {
							break;
						} //else if				
					} //if					
				} //for
				

				//Checks to the upper right diagonally
				//comments above are all the same for the different check directions below
				int checkPieceSix=0, checkStopSix=1, otherPieceSix=0, flipPiecesSix=0, endFlipSix=0, checkSkipSix=0;
				for(int i=r-1, j=c+1; i>=0 && j<col; i--, j++) {
					if(!board[i][j].equals(oppositePiece)) {
						checkSkipSix=1;
					} //if
					if(board[i][j].equals(oppositePiece) && checkSkipSix==0) {
						if(checkStopSix==1) {
							for(int k=i, l=j; k>=0 && l<col; k--, l++) {
								if(board[k][l].equals(oppositePiece)) {
									checkPieceSix=1;
									endFlipSix++;
									continue;
								} //if
								if(board[k][l].equals(". ") || board[k][l].equals("_ ") || ((k==0 && j==col-1) && board[k][l].equals(oppositePiece))){
									otherPieceSix=1;
									endFlipSix++;
									break;
								} //else
								if(board[k][l].equals(playerPiece) && checkPieceSix==1 && otherPieceSix!=1) {
									flipPiecesSix=1;
									checkStopSix=0;
									break;
								} //if
							} //for
						} //if 
						if(flipPiecesSix==1 && board[i][j].equals(oppositePiece) && endFlipSix>0) {
							if(!IntelligentComputerPlayer.intelligentExecute) {
								board[i][j]=(playerPiece);
							} //if
							endFlipSix--;
							intelligentPieces++;
							continue;
						} //if
						else if(board[i][j].equals(playerPiece)) {
							break;
						} //else if				
					} //if				
				} //for

				
				//Checks to the lower right diagonally
				//comments above are all the same for the different check directions below
				int checkPieceSeven=0, checkStopSeven=1, otherPieceSeven=0, flipPiecesSeven=0, endFlipSeven=0, checkSkipSeven=0;
				for(int i=r+1, j=c+1; i<row && j<col; i++, j++) {
					if(!board[i][j].equals(oppositePiece)) {
						checkSkipSeven=1;
					} //if
					if(board[i][j].equals(oppositePiece) && checkSkipSeven==0) {
						if(checkStopSeven==1) {
							for(int k=i, l=j; k<row && l<col; k++, l++) {
								if(board[k][l].equals(oppositePiece)) {
									checkPieceSeven=1;
									endFlipSeven++;
									continue;
								} //if
								if(board[k][l].equals(". ") || board[k][l].equals("_ ") || ((k==row-1 && j==col-1) && board[k][l].equals(oppositePiece))){
									otherPieceSeven=1;
									endFlipSeven=0;
									break;
								} //if
								if(board[k][l].equals(playerPiece) && checkPieceSeven==1 && otherPieceSeven!=1) {
									flipPiecesSeven=1;
									checkStopSeven=0;
									break;
								} //if
							} //for
						} //if 
						if(flipPiecesSeven==1 && board[i][j].equals(oppositePiece) && endFlipSeven>0) {
							if(!IntelligentComputerPlayer.intelligentExecute) {
								board[i][j]=(playerPiece);
							} //if
							endFlipSeven--;
							intelligentPieces++;
							continue;
						} //if
						else if(board[i][j].equals(playerPiece)) {
							break;
						} //else if				
					} //if					
				} //for
				
				
				//Checks to the lower left diagonally
				//comments above are all the same for the different check directions below
				int checkPieceEight=0, checkStopEight=1, otherPieceEight=0, flipPiecesEight=0, endFlipEight=0, checkSkipEight=0;
				for(int i=r+1, j=c-1; i<row && j>=0; i++, j--) {
					if(!board[i][j].equals(oppositePiece)) {
						checkSkipEight=1;
					} //if
					if(board[i][j].equals(oppositePiece) && checkSkipEight==0) {
						if(checkStopEight==1) {
							for(int k=i, l=j; k<row && l>=0; k++, l--) {
								if(board[k][l].equals(oppositePiece)) {
									checkPieceEight=1;
									endFlipEight++;
									continue;
								} //if
								if(board[k][l].equals(". ") || board[k][l].equals("_ ") || ((k==row-1 && j==0) && board[k][l].equals(oppositePiece))){
									otherPieceEight=1;
									endFlipEight=0;
									break;
								} //if
								if(board[k][l].equals(playerPiece) && checkPieceEight==1 && otherPieceEight!=1) {
									flipPiecesEight=1;
									checkStopEight=0;
									break;
								} //if
							} //for
						} //if 
						if(flipPiecesEight==1 && board[i][j].equals(oppositePiece) && endFlipEight>0) {
							if(!IntelligentComputerPlayer.intelligentExecute) {
								board[i][j]=(playerPiece);
							} //if
							endFlipEight--;
							intelligentPieces++;
							continue;
						} //if
						else if(board[i][j].equals(playerPiece)) {
							break;
						} //else if				
					} //if	
				} //for	
				
				if(p.getClassName() == "IntelligentComputerPlayer") {
					IntelligentComputerPlayer.pointsForEachMove[r][c]=intelligentPieces; 
				}
				//puts the amount of flips possible for that move into an array 
				//used to determine intelligent computer move
				
			} //if
				
		}
// ________________________________________________________________________________________________________	
		
		/**
		 * Determines all possible moves for a player and returns an 8x8 boolean array containing true/false values for each
		 * space depending on whether or not the space is a valid move for the player
		 * @param p the player for which all possible moves are being determined
		 */
		public boolean[][] getValidMovesFor(Player p) {
			
			boolean[][] validMoves = new boolean[row][col];
			
			String oppositePiece, playerPiece;
			if(p.getPieceIdentifier().equals("X ")) {
				oppositePiece = "O ";
				playerPiece = "X ";
			} else {
				oppositePiece = "X ";
				playerPiece = "O ";
			}
			
			for(int r=0; r<row; r++) {
				
				for(int c=0; c<col; c++) {
					
					//Locate the player piece
					int locatePiece=0;
					if(board[r][c].equals(playerPiece)) {
						locatePiece=1;
					} //if
					
					if(locatePiece==1) {
					
						//Checks to the right horizontally
						int didContinue=1, didFindOppositePiece=0;
						for(int i=c+1; i<col; i++) {
							if(board[r][i].equals(". ") && didFindOppositePiece==0) {
								didContinue=0;
								break;
							} //if
							if(board[r][i].equals(oppositePiece) && didContinue==1) {
								didFindOppositePiece=1;
								continue;
							} //if
							else if(!board[r][i].equals(oppositePiece) && !board[r][i].equals(". ") && didContinue==1) {
								break;
							} //else if
							else if(board[r][i].equals(". ") && didFindOppositePiece==1 && didContinue==1) {
								board[r][i]="_ ";
								validMoves[r][i] = true;
								break;
							} //else if
						} //for
				
						
						//Checks to the left horizontally
						int didContinueTwo=1, didFindOppositePieceTwo=0;
						for(int i=c-1; i>=0; i--) {
							if(board[r][i].equals(". ") && didFindOppositePieceTwo==0) {
								didContinueTwo=0;
								break;
							} //if
							if(board[r][i].equals(oppositePiece) && didContinueTwo==1) {
								didFindOppositePieceTwo=1;
								continue;
							} //if
							else if(!board[r][i].equals(oppositePiece) && !board[r][i].equals(". ") && didContinueTwo==1) {
								break;
							} //else if
							else if(board[r][i].equals(". ") && didFindOppositePieceTwo==1 && didContinueTwo==1) {
								board[r][i]="_ ";
								validMoves[r][i] = true;
								break;
							} //else if
						} //for
				
				
						//Checks down vertically
						int didContinueThree=1, didFindOppositePieceThree=0;
						for(int i=r+1; i<row; i++) {
							if(board[i][c].equals(". ") && didFindOppositePieceThree==0) {
								didContinueThree=0;
								break;
							} //if
							if(board[i][c].equals(oppositePiece) && didContinueThree==1) {
								didFindOppositePieceThree=1;
								continue;
							} //if
							else if(!board[i][c].equals(oppositePiece) && !board[i][c].equals(". ") && didContinueThree==1) {
									break;
							} //else if
							else if(board[i][c].equals(". ") && didFindOppositePieceThree==1 && didContinueThree==1) {
								board[i][c]="_ ";
								validMoves[i][c] = true;
								break;
							} //else if
						} //for
						
						
						//Checks up vertically
						int didContinueFour=1, didFindOppositePieceFour=0;
						for(int i=r-1; i>=0; i--) {
							if(board[i][c].equals(". ") && didFindOppositePieceFour==0) {
								didContinueFour=0;
								break;
							} //if
							if(board[i][c].equals(oppositePiece) && didContinueFour==1) {
								didFindOppositePieceFour=1;
								continue;
							} //if
							else if(!board[i][c].equals(oppositePiece) && !board[i][c].equals(". ") && didContinueFour==1) {
								break;
							} //else if
							else if(board[i][c].equals(". ") && didFindOppositePieceFour==1 && didContinueFour==1) {
								board[i][c]="_ ";
								validMoves[i][c] = true;
								break;
							} //else if
						} //for
						
						
						//Checks to the upper left diagonally
						int didContinueFive=1, didFindOppositePieceFive=0;
						for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--) {
							if(board[i][j].equals(". ") && didFindOppositePieceFive==0) {
								didContinueFive=0;
								break;
							} //if
							else if(board[i][j].equals(oppositePiece) && didContinueFive==1) {
								didFindOppositePieceFive=1;
								continue;
							} //if
							else if(!board[i][j].equals(oppositePiece) && !board[i][j].equals(". ")) {
								break;
							} //else if
							else if(board[i][j].equals(". ") && didFindOppositePieceFive==1 ) {
								board[i][j]="_ ";
								validMoves[i][j] = true;
								break;
							} //else if
						} //for
						
						
						//Checks to the upper right diagonally
						int didContinueSix=1, didFindOppositePieceSix=0;
						for(int i=r-1, j=c+1; i>=0 && j<col; i--, j++) {
							if(board[i][j].equals(". ") && didFindOppositePieceSix==0) {
								didContinueSix=0;
								break;
							} //if
							if(board[i][j].equals(oppositePiece) && didContinueSix==1) {
								didFindOppositePieceSix=1;
								continue;
							} //if
							else if(!board[i][j].equals(oppositePiece) && !board[i][j].equals(". ")) {
								break;
							} //else if
							else if(board[i][j].equals(". ") && didFindOppositePieceSix==1) {
								board[i][j]="_ ";
								validMoves[i][j] = true;
								break;
							} //else if
						} //for
						
						
						//Checks to the lower right diagonally
						int didContinueSeven=1, didFindOppositePieceSeven=0;
						for(int i=r+1, j=c+1; i<row && j<col; i++, j++) {
							if(board[i][j].equals(". ") && didFindOppositePieceSeven==0) {
								didContinueSeven=0;
								break;
							} //if
							if(board[i][j].equals(oppositePiece) && didContinueSeven==1) {
								didFindOppositePieceSeven=1;
								continue;
							} //if
							else if(!board[i][j].equals(oppositePiece) && !board[i][j].equals(". ")) {
								break;
							} //else if
							else if(board[i][j].equals(". ") && didFindOppositePieceSeven==1) {
								board[i][j]="_ ";
								validMoves[i][j] = true;
								break;
							} //else if
						} //for
						
						
						//Checks to the lower left diagonally
						int didContinueEight=1, didFindOppositePieceEight=0;
						for(int i=r+1, j=c-1; i<row && j>=0; i++, j--) {
							if(board[i][j].equals(". ") && didFindOppositePieceEight==0) {
								didContinueEight=0;
								break;
							} //if
							if(board[i][j].equals(oppositePiece) && didContinueEight==1) {
								didFindOppositePieceEight=1;
								continue;
							} //if
							else if(!board[i][j].equals(oppositePiece) && !board[i][j].equals(". ")) {
								break;
							} //else if
							else if(board[i][j].equals(". ") && didFindOppositePieceEight==1) {
								board[i][j]="_ ";
								validMoves[i][j] = true;
								break;
							} //else if
						} //for
					
					} //if
			
				} //for	
			
			} //for
			return validMoves;
		}
// ________________________________________________________________________________________________________	
		
		/**
		 * Clears the underscores from the board
		 */
		public void clearUnderscores() {
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					if(board[i][j] == "_ ") {
						board[i][j] = ". ";
					}
				}
			}
		}
// ________________________________________________________________________________________________________	
		
		/**
		 * Gets the board String[][]
		 */
		public String[][] getBoard() {
			return this.board;
		}
// ________________________________________________________________________________________________________
		
		/**
		 * Counts the number of "X" on the game board.
		 * @return the number of "X"
		 */
		public int countNumX() {
			int numX = 0;
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {
					if(board[i][j] == "X ") {
						numX++;
					}
				}
			}
			return numX;
		}
// ________________________________________________________________________________________________________

		/**
		 * Counts the number of "O" on the game board.
		 * @return the number of "O"
		 */
		public int countNumO() {
			int numO = 0;
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {
					if(board[i][j] == "O ") {
						numO++;
					}
				}
			}
			return numO;
		}
// ________________________________________________________________________________________________________
		
		public boolean isFull() {
			return (countNumX() + countNumO()) == board.length*board.length;
		}
		

} // ReversiBoard
