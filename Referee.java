package lePack;

import java.io.IOException;

/**
* This class presets the two players 'X' and 'O', and calls for the first player
* (which is always 'X') to start the match. This class acts as a midd
* @author Rifat Haque
* @version 1.0
* @since February 6, 2020
* 
*/
public class Referee {
	private Player xPlayer;
	private Player oPlayer;
	private Board board;
	/**
	 * Returns the player X.
	 * @return xPlayer
	 */
	public Player getxPlayer() {
		return xPlayer;
	}

/**
 * Sets the object xPlayer to the call of xPlayer.
 * @param xPlayer the designation for X player
 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}

	/**
	 * Returns the player O.
	 * @return oPlayer
	 */
	public Player getoPlayer() {
		return oPlayer;
	}

	/**
	 * Sets the object oPlayer to the call of oPlayer.
	 * @param oPlayer the designation for O player
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
/**
 * Gets the board.
 * @return board
 */

	public Board getBoard() {
		return board;
	}

/**
 * Sets the board.
 * @param board the game board.
 */
	public void setBoard(Board board) {
		this.board = board;
	}
/**
 * Sets up the game, and calls for the start of the match.
 * This method also designates the opponents of play X and O through calling their class
 * method Player setOpponent, which takes type Player and connects the two objects.
 * This allows the alternating of turns through the play() method within the Player class.
 * @throws IOException if IO exception occurs, then the program closes
 */

public void runTheGame() throws IOException {
	
	xPlayer.setOpponent(oPlayer);
	oPlayer.setOpponent(xPlayer);
	board.display();
	xPlayer.play();
	
}


}
