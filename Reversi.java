public class Reversi {
	
	public enum GameType {
		HUMAN_VS_HUMAN, 
		HUMAN_VS_RANDOM,
		HUMAN_VS_INTEL, 
		RANDOM_VS_RANDOM, 
		RANDOM_VS_INTEL, 
		RANDOM_VS_HUMAN, 
		INTEL_VS_INTEL, 
		INTEL_VS_RANDOM, 
		INTEL_VS_HUMAN
	} // GameType (determined from terminal arguments)
	
	private ReversiBoard board;
	private HumanPlayer human;
	private HumanPlayer human2;
	private RandomComputerPlayer randomCPU;
	private RandomComputerPlayer randomCPU2;
	private IntelligentComputerPlayer intelligentCPU;
	private IntelligentComputerPlayer intelligentCPU2;
	private GameType type;
//___________________________________________________________________________________________
	
	// Below are the 9 constructors... :(
	
	/**
	 * Creates Reversi game with HumanPlayer vs. HumanPlayer
	 * @param player1 the type of player1
	 * @param player2 the type of player2
	 */
	public Reversi(HumanPlayer player1, HumanPlayer player2) {
		board = new ReversiBoard();
		human = player1;
		human2 = player2;
		type = GameType.HUMAN_VS_HUMAN;
		
		randomCPU = null;
		randomCPU2 = null;
		intelligentCPU = null;
		intelligentCPU2 = null;
	} // constructor
	
	/**
	 * Creates Reversi game with HumanPlayer vs. RandomComputerPlayer
	 * @param player1 the type of player1
	 * @param player2 the type of player2
	 */
	public Reversi(HumanPlayer player1, RandomComputerPlayer player2) {
		board = new ReversiBoard();
		human = player1;
		randomCPU = player2;
		type = GameType.HUMAN_VS_RANDOM;
		
		human2 = null;
		randomCPU2 = null;
		intelligentCPU = null;
		intelligentCPU2 = null;
	} // constructor
	
	/**
	 * Creates Reversi game with HumanPlayer vs. IntelligentComputerPlayer
	 * @param player1 the type of player1
	 * @param player2 the type of player2
	 */
	public Reversi(HumanPlayer player1, IntelligentComputerPlayer player2) {
		board = new ReversiBoard();
		human = player1;
		intelligentCPU = player2;
		type = GameType.HUMAN_VS_INTEL;
		
		human2 = null;
		randomCPU = null;
		randomCPU2 = null;
		intelligentCPU2 = null;
	} // constructor
	
	/**
	 * Creates Reversi game with RandomComputerPlayer vs. RandomComputerPlayer
	 * @param player1 the type of player1
	 * @param player2 the type of player2
	 */
	public Reversi(RandomComputerPlayer player1, RandomComputerPlayer player2) {
		board = new ReversiBoard();
		randomCPU = player1;
		randomCPU2 = player2;
		type = GameType.RANDOM_VS_RANDOM;
		
		human = null;
		human2 = null;
		intelligentCPU = null;
		intelligentCPU2 = null;
	} // constructor
	
	/**
	 * Creates Reversi game with RandomComputerPlayer vs. IntelligentComputerPlayer
	 * @param player1 the type of player1
	 * @param player2 the type of player2
	 */
	public Reversi(RandomComputerPlayer player1, IntelligentComputerPlayer player2) {
		board = new ReversiBoard();
		randomCPU = player1;
		intelligentCPU = player2;
		type = GameType.RANDOM_VS_INTEL;
		
		human = null;
		human2 = null;
		randomCPU2 = null;
		intelligentCPU2 = null;
	} //constructor
	
	/**
	 * Creates Reversi game with RandomComputerPlayer vs. HumanPlayer
	 * @param player1 the type of player1
	 * @param player2 the type of player2
	 */
	public Reversi(RandomComputerPlayer player1, HumanPlayer player2) {
		board = new ReversiBoard();
		randomCPU = player1;
		human = player2;
		type = GameType.RANDOM_VS_HUMAN;
		
		human2 = null;
		randomCPU2 = null;
		intelligentCPU = null;
		intelligentCPU2 = null;
	} //constructor
	
	/**
	 * Creates Reversi game with IntelligentComputerPlayer vs. IntelligentComputerPlayer
	 * @param player1 the type of player1
	 * @param player2 the type of player2
	 */
	public Reversi(IntelligentComputerPlayer player1, IntelligentComputerPlayer player2) {
		board = new ReversiBoard();
		intelligentCPU = player1;
		intelligentCPU2 = player2;
		type = GameType.INTEL_VS_INTEL;
		
		human = null;
		human2 = null;
		randomCPU = null;
		randomCPU2 = null;
	} //constructor
	
	/**
	 * Creates Reversi game with IntelligentComputerPlayer vs. RandomComputerPlayer
	 * @param player1 the type of player1
	 * @param player2 the type of player2
	 */
	public Reversi(IntelligentComputerPlayer player1, RandomComputerPlayer player2) {
		board = new ReversiBoard();
		intelligentCPU = player1;
		randomCPU = player2;
		type = GameType.INTEL_VS_RANDOM;
		
		human = null;
		human2 = null;
		randomCPU2 = null;
		intelligentCPU2 = null;
	} //constructor
	
	/**
	 * Creates Reversi game with IntelligentComputerPlayer vs. HumanPlayer
	 * @param player1 the type of player1
	 * @param player2 the type of player2
	 */
	public Reversi(IntelligentComputerPlayer player1, HumanPlayer player2) {
		board = new ReversiBoard();
		intelligentCPU = player1;
		human = player2;
		type = GameType.INTEL_VS_HUMAN;
		
		human2 = null;
		randomCPU = null;
		randomCPU2 = null;
		intelligentCPU2 = null;
	} //constructor
	
//___________________________________________________________________________________________///
//___________________________________________________________________________________________///
//__________________________________END OF CONSTRUCTORS______________________________________///
//___________________________________________________________________________________________///
//___________________________________________________________________________________________///

	/**
	 * Main method
	 * @param args the command line arguments from the user
	 */
	public static void main(String[] args) {
		
		Reversi game = null;

		switch (args.length) {
		
		case 2: 
			
			if(args[0].equals("Human") && args[1].equals("Human")) {
				game = new Reversi(new HumanPlayer("X "), new HumanPlayer("O "));
				break;
			} else if(args[0].equals("Human") && args[1].equals("RandomComputerPlayer")) {
				game = new Reversi(new HumanPlayer("X "), new RandomComputerPlayer("O "));
				break;
			} else if(args[0].equals("Human") && args[1].equals("IntelligentComputerPlayer")) {
				game = new Reversi(new HumanPlayer("X "), new IntelligentComputerPlayer("O "));
				break;
			} else if(args[0].equals("RandomComputerPlayer") && args[1].equals("RandomComputerPlayer")) {
				game = new Reversi(new RandomComputerPlayer("X "), new RandomComputerPlayer("O "));
				break;
			} else if(args[0].equals("RandomComputerPlayer") && args[1].equals("IntelligentComputerPlayer")) {
				game = new Reversi(new RandomComputerPlayer("X "), new IntelligentComputerPlayer("O "));
				break;
			} else if(args[0].equals("RandomComputerPlayer") && args[1].equals("Human")) {
				game = new Reversi(new RandomComputerPlayer("X "), new HumanPlayer("O "));
				break;
			} else if(args[0].equals("IntelligentComputerPlayer") && args[1].equals("IntelligentComputerPlayer")) {
				game = new Reversi(new IntelligentComputerPlayer("X "), new IntelligentComputerPlayer("O "));
				break;
			} else if(args[0].equals("IntelligentComputerPlayer") && args[1].equals("RandomComputerPlayer")) {
				game = new Reversi(new IntelligentComputerPlayer("X "), new RandomComputerPlayer("O "));
				break;
			} else if(args[0].equals("IntelligentComputerPlayer") && args[1].equals("Human")) {
				game = new Reversi(new IntelligentComputerPlayer("X "), new HumanPlayer("O "));
				break;
			}
			
		default:
			
			// display usage statement

		    System.out.println("Usage: java Reversi [PLAYER 1 TYPE] [PLAYER 2 TYPE]");
		    System.exit(0);

		} // switch

		// if all is good, then run the game
	    game.run();
	    	
	} // main()


//___________________________________________________________________________________________
	
	
	/**
	 * Runs the game.
	 */
	private void run() {
		
		printWelcome();
		
		switch (this.type) {
		
		case HUMAN_VS_HUMAN: 
			while(true) {
				this.<HumanPlayer>playTurn(human);
				determineWinner(human, human2);
				this.<HumanPlayer>playTurn(human2);
				determineWinner(human, human2);
			}
		case HUMAN_VS_RANDOM:
			while(true) {
				this.<HumanPlayer>playTurn(human);
				determineWinner(human, randomCPU);
				this.<RandomComputerPlayer>playTurn(randomCPU);
				determineWinner(human, randomCPU);
			}
		case HUMAN_VS_INTEL:
			while(true) {
				this.<HumanPlayer>playTurn(human);
				determineWinner(human, intelligentCPU);
				this.<IntelligentComputerPlayer>playTurn(intelligentCPU);
				determineWinner(human, intelligentCPU);
			}
		case RANDOM_VS_RANDOM: 
			while(true) {
				this.<RandomComputerPlayer>playTurn(randomCPU);
				determineWinner(randomCPU, randomCPU2);
				this.<RandomComputerPlayer>playTurn(randomCPU2);
				determineWinner(randomCPU, randomCPU2);
			}
		case RANDOM_VS_INTEL:
			while(true) {
				this.<RandomComputerPlayer>playTurn(randomCPU);
				determineWinner(randomCPU, intelligentCPU);
				this.<IntelligentComputerPlayer>playTurn(intelligentCPU);
				determineWinner(randomCPU, intelligentCPU);
			}
		case RANDOM_VS_HUMAN:
			while(true) {
				this.<RandomComputerPlayer>playTurn(randomCPU);
				determineWinner(randomCPU, human);
				this.<HumanPlayer>playTurn(human);
				determineWinner(randomCPU, human);
			}
		case INTEL_VS_INTEL: 
			while(true) {
				this.<IntelligentComputerPlayer>playTurn(intelligentCPU);
				determineWinner(intelligentCPU, intelligentCPU2);
				this.<IntelligentComputerPlayer>playTurn(intelligentCPU2);
				determineWinner(intelligentCPU, intelligentCPU2);
			}
		case INTEL_VS_RANDOM:
			while(true) {
				this.<IntelligentComputerPlayer>playTurn(intelligentCPU);
				determineWinner(intelligentCPU, randomCPU);
				this.<RandomComputerPlayer>playTurn(randomCPU);
				determineWinner(intelligentCPU, randomCPU);
			}
		case INTEL_VS_HUMAN:
			while(true) {
				this.<IntelligentComputerPlayer>playTurn(intelligentCPU);
				determineWinner(intelligentCPU, human);
				this.<HumanPlayer>playTurn(human);
				determineWinner(intelligentCPU, human);
			}
		}
	} // run()
//___________________________________________________________________________________________
	
	/**
	 * Prints welcome message.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("Welcome to Reversi!  Moves should be entered in a \"[row] [column]\" format.");
		System.out.println();
	}
//___________________________________________________________________________________________	
	
	/**
	 * Prints forfeit message.
	 * @param p the player who is forfeiting
	 */
	private void printForfeit(Player p) {
		System.out.println();
		System.out.println(p.getPieceIdentifier() + "has no valid moves." + " Turn forfeited.");
		System.out.println();
	}
//___________________________________________________________________________________________	
	
	/**
	 * Plays a turn of any player type.
	 * @param player the player object attempting to play their turn
	 */
	private <T extends Player> void playTurn(T player) {
		
		player.setValidMovesArray(board.getValidMovesFor(player));
		if(!player.hasValidMoveLeft()) {
			player.setDidForfeitTurn(true);
			printForfeit(player);
		} else {
			player.setDidForfeitTurn(false);
		}
		
		if(!player.getDidForfeitTurn()) {
			printScore(); // TODO: delete before turning in
			board.printBoard();
			player.chooseMove(board);
			player.setValidMovesArray(null);
		} 
	}
//______________________________________________________________________________________________________________
	
	/**
	 * After a turn of play, determines if anyone has won the game.
	 * @param p1 the first player to check
	 * @param p2 the second player to check
	 */
	private void determineWinner(Player p1, Player p2) {
		if((p1.getDidForfeitTurn() && p2.getDidForfeitTurn()) || board.isFull()) {
			if(board.countNumX() > board.countNumO()) {
				player1Wins();
			} else if(board.countNumO() > board.countNumX()) {
				player2Wins();
			} else {
				tie();
			}
		} // checks if either both players forfeited, or if the board is full
	} 
//______________________________________________________________________________________________________________
	
	/**
	 * Prints winning message for human, prints final score, ends the game.
	 */
	private void player1Wins() {
		System.out.println();
		System.out.println("X player wins!");
		System.out.println();
		System.out.println("FINAL SCORE: X=" + board.countNumX() + " , O=" + board.countNumO());
		System.out.println();
		board.printBoard();
		System.exit(0);
	}
//______________________________________________________________________________________________________________
	
	/**
	 * Prints winning message for random computer, prints final score, ends the game.
	 */
	private void player2Wins() {
		System.out.println();
		System.out.println("O player wins!");
		System.out.println();
		System.out.println("FINAL SCORE: O=" + board.countNumO() + " , X=" + board.countNumX());
		System.out.println();
		board.printBoard();
		System.exit(0);
	}
//______________________________________________________________________________________________________________	
	
	/**
	 * Prints draw message, prints final score, ends the game.
	 */
	private void tie() {
		System.out.println();
		System.out.println("It's a draw!");
		System.out.println();
		System.out.println("FINAL SCORE: X=" + board.countNumX() + " , O=" + board.countNumO());
		System.out.println();
		board.printBoard();
		System.exit(0);
	}
//______________________________________________________________________________________________________________
	
	/**
	 * Prints current score.
	 */
	private void printScore() {
		System.out.println();
		System.out.println("  SCORE: X=" + board.countNumX() + " , O=" + board.countNumO());
		System.out.println();
	}

} // Reversi

// TOTAL LINES OF CODE IN PROJECT: 1155
