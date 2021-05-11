package lePack;
import java.io.IOException;
import java.util.Scanner;

public class HumanPlayer extends Player {
	
	public HumanPlayer(String name,char  mark) {
		super(name,mark);
	}


@Override
public void makeMove()throws IOException{
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.print("Please enter the column of your move: ");
		int col = in.nextInt();
		while (col < 0 || col >= 3) {
			System.out.print("Please try again: ");
			col = in.nextInt();
		}
	System.out.print("Please enter the row of your move: ");
	int row = in.nextInt();
	while (row < 0 || row >= 3) {
		System.out.print("Please try again: ");
		row = in.nextInt();
	}
	if(board.getMark(row, col) != ' ') {
		System.out.println("Spot is taken bud:  ");
		makeMove();
	}
	if(board.getMark(row, col) == ' ')
		board.addMark(row, col, mark);
}

}
