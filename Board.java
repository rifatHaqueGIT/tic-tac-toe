package lePack;
/**
 * This class creates and manages the tik-tak-toe board.
 * @author Rifat Haque
 * @version 1.0
 * @since February 6, 2020
 *
 */
public class Board implements Constants {
	private char theBoard[][];
	private int markCount;
/**
 * The default constructor for board, creates a 3 by 3 table.
 * This table is where the players place their X's and O's.
 * The table is created using and filling a three by three array which is initialized
 * with blank spaces.
 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
/**
 * This method returns the value present on the board for the chosen index.
 * getMark takes in the values of the asked for index and returns the value as an 
 * x, o, or blank space, thus representing which player if any has used that position.
 * @param row is the first coordinate to be checked on the Board theBoard
 * @param col is the second coordinate to be checked on the Board theBoard
 * @return the value at the specified index on Board theBoard
 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
/**
 * This class ends the game by changing the amount of pieces allowed to max count.
 * @return the markCount is set to 9 
 */
	public boolean isFull() {
		return markCount == 9;
	}
/**
 * This class checks if the winner is player X.
 * If player x wins it returns true, otherwise it returns false.
 * @return it returns true if xPlayer wins 
 * @return it returns false if xPlayer does not win
 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
/**
 This class checks if the winner is player O.
 * If player O wins it returns true, otherwise it returns false.
 * @return it returns true if oPlayer wins 
 * @return it returns false if oPlayer does not win
 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}
/**
 * This method provides the visual presentation of the current game board.
 * Display constantly updates the board to its current state of the game, placing each
 * of the players placements of x and o on the board with each passing turn. 
 * It does this task through calling function addSpaces, displayColoumnHeaders, 
 * addHyphens, and a nested for loop to display the labels of the rows and columns
 * of the board.
 * The for loop also calls the getMark to check if any player has made a move on the 
 * board, if they did it will place that players marker on that position, else it will
 * be a blank space.  
 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}
/**
 * A marker is chosen and placed in the Board theBoard two-dimensional array at a 
 * specified index on the array.
 * After which the marker count is increased by one and the array is filled at that
 * index as a specified player to be x or o. The array is filled with blank spaces
 * by default, therefore it is redundant to send a blank space into this function.
 * 
 * @param row the index for the first parameter inside Board theBoard
 * @param col the index for the second parameter inside Board theBoard
 * @param mark is an x or o to represent a players move
 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}
/**
 * Removes all the markers placed on theBoard with blank spaces.
 * This resets the board to be played on again, erasing all the previous round
 * marks and sets mark count to zero.
 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}
/**
 * Checks the board for whether a player has a row, column, or diagonal with only
 * their markers. 
 * This is done through a series of for loops and if statements to check whether or
 * not a player has achieved the specified conditions above.
 * @param mark is either x or o to represent xPlayer or oPlayer
 * @return 1 if the player meets one of the conditions or 0
 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
/**
 * This method displays the columns and column numbers at the top of the board.
 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}
/**
 * Adds hyphens to partition each row on the display.
 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
/**
 * Places a space and creates the columns on the board.
 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
