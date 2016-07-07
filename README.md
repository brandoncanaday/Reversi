Reversi.java INSTRUCTIONS (for compiling and running)	@authors Brandon Canaday, Jeffrey Nguyen

These are instructions on how to compile and run the Reversi.java program from the terminal, assuming
the user is starting in the same directory as Reversi.java.

1) Enter the command 'javac *.java'. This will compile all of the .java programs in the current directory (ones associated with the Reversi.java driver,
   as well as Reversi.java itself).

2) To run the Reversi program, enter ‘java Reversi [Player 1 Type] [Player 2 Type]’, inserting either ‘Human’, ‘RandomComputerPlayer’,
   or ‘IntelligentComputerPlayer’ in each of the bracketed areas. This will create a game of Reversi with the specified participants.
   (Note that in Reversi, the X (dark) player always goes first, and in this implementation, Player 1 is always X.)

   Ex. ‘java Reversi Human RandomComputerPlayer’, ‘java Reversi RandomComputerPlayer IntelligentComputerPlayer’, etc.

3) The game is played by placing your piece at a valid, specified row/col position on the 8x8 Reversi game board. The valid moves for each 
   turn are denoted with an ‘_’ on the displayed game board. The player with the most pieces of his/her/its own type on the board when the game
   ends is the winner. 

4) The game ends when one of the following occurs: 1. the board is full, or 2. both players forfeit their turn due to lack of valid moves.

5) Enjoy!


**Implementation of IntelligentComputerPlayer**

To choose the best move out of all the possible valid moves for that turn, the intelligent computer player determines point values 
for each possible move, and then chooses the move which has the highest point value. The point values == the number of opposing pieces that
would be flipped. This implementation is the “greedy” one. Note: this strategy does not necessarily guarantee a win against a RandomComputerPlayer
every time due to the fact that the IntelligentComputerPlayer does not take into account the future cost/benefit of a particular move, only the 
benefit of said move on the current turn. Where a RandomComputerPlayer might not choose the highest point move at the time, its chosen move might
cause greater benefit for it in future turns.