package lePack;

import java.io.IOException;

public class RandomPlayer extends Player {
	
	public RandomPlayer(String name,char  mark) {
		super(name,mark);
	}

@Override
public void makeMove()throws IOException {
	randomPicker() ;
			
			
}
public void randomPicker() {
	RandomGenerator rando = new RandomGenerator();
	int col =rando.discrete(0,2);
	int row =rando.discrete(0,2);
	while(board.getMark(row,col) != ' ') {
		col = rando.discrete(0, 2);
		row = rando.discrete(0, 2);
	}
	if(board.getMark(row,col) == ' ') {
		board.addMark(row,col,mark);
	}
	
}
	
}
