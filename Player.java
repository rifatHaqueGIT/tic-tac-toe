package lePack;
import java.io.*;

/**
 * Player creates the profile for each participant in the game, then the class plays the
 * turn of the current player and proceeds to pass the turn to the opposing player.
 * This is done through designating an opponent, which is achieved through 
 * user inputs for name and their corresponding mark being assigned
 * at the starting menu, then their opponent is decided as the opposing player, if you 
 * are the X player your opponent is the O player, and vice versa. Then the game starts
 * and the player must choose the column and row they would like to place their
 * respective mark upon. When three marks are connected the game ends, and a winner 
 * is designated.
 * 
 * @author Rifat Haque
 * @version 1.0
 * @since February 6, 2020
 */

abstract class  Player {
	
protected String name;
protected Board board;
protected Player opponent;
protected char mark;
/**
 * Player constructor which initializes the name and the player to their 
 * roles.
 * @param name is the String name of the person playing
 * @param mark either X or O to differentiate the two opponents
 *  
 */
public Player(String name, char mark) {
	this.name = name;
	this.mark = mark;
}
/**
 * getter for name.
 * @return name of player
 */
public String getName() {
	return name;
}
/**
 * Setter for name.
 * @param name of the player
 */
public void setName(String name) {
	this.name = name;
}
/**
 * Gets the board.
 * @return board which the game is played on
 */
public Board getBoard() {
	return board;
}
/**
 * Gets opponent.
 * @return opponent of the current player
 */
public Player getOpponent() {
	return opponent;
}
/**
 * Gets mark.
 * @return mark
 */
public char getMark() {
	return mark;
}
/**
 * Setter for mark.
 * @param mark 'X' or 'O' to represent the player
 */
public void setMark(char mark) {
	this.mark = mark;
}
/**
 * Sets the board allowing for the space allocated in which the game is played.
 * @param board the Board board in which the game is played
 */
public void setBoard(Board board) {
	this.board = board;
}
/**
 * Sets the opponent.
 * @param opponent the opposing player
 */
		
public void setOpponent(Player opponent) {
	this.opponent = opponent;
}
/**
 * Checks the if the win conditions are met, and creates the loop in which the game is played
 * till a victor is found. This method calls makeMove to play the turn and keeps
 * the order of switching from opponent to opponent, starting with player X.
 * The game is stopped when a win condition is met (either a tie or X or O player wins).
 * A tie occurs when all 9 spaces are taken without a clear victor, and the other two 
 * conditions matter on the method checkWinner in class board to return true for either 
 * player X or O.
 * @throws IOException 
 */
protected void play() throws IOException {
	
	if(board.xWins()) {
		System.out.println("Player X,"+ opponent.getName() +" is the winner! ");
		System.out.println("The game is finished");
		System.exit(0);
	}
	if(board.oWins()) {
		System.out.println("Player O,"+ opponent.getName() +" is the winner! ");
		System.out.println("The game is finished");	
		System.exit(0);
	}
	if(board.isFull()) {
		System.out.print("Neither player won it is a tie. ");
		System.out.println("The game is finished");
		System.exit(0);
		}
	makeMove();
	board.display();
	opponent.play();
	
}
	
	

/**
 * This method plays the turn of the current player, allowing the selection of which column
 * and row they wish to place their marker upon. If a position is taken, or a incorrect input
 * is made the game will keep asking the user to put in a valid input.
 * @throws IOException
 */
abstract void makeMove()throws IOException;

}
