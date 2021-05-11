package lePack;

public class BlockingPlayer extends RandomPlayer {
	private boolean blockable = false;
	private int blockRow;
	private int blockCol;
	
	public BlockingPlayer(String name,char  mark) {
		super(name,mark);
	}
	@Override
	public void makeMove() {
		checkBlock();
		if(blockable == false)
			randomPicker();
		if(blockable == true) 
			board.addMark(blockRow,blockCol,mark);
		
		blockable = false;
	}
	
	private void checkBlock() {
		int row,col,tempCol = 0 ,tempRow = 0;
		
		for (row = 0;  row < 3; row++) {
			int mark_count = 0;
			for (col = 0;col < 3; col++) {
				if (board.getMark(row, col) == opponent.mark)
					mark_count++;
				if(board.getMark(row, col)== ' ') 
					tempCol = col;
				
				if(mark_count == 2 && board.getMark(row, tempCol) ==' ') {
					blockRow = row;
					blockCol = tempCol;
					blockable = true;
					
					
				}
				}	
		}
	if(blockable == false){
		for (col = 0;  col < 3; col++) {
			int mark_count = 0;
			for (row = 0;row < 3; row++) {
				if (board.getMark(row, col) == opponent.mark)
					mark_count++;
				if(board.getMark(row, col)== ' ') 
					tempRow = row;
				//System.out.print(mark_count);	
				if(mark_count == 2 && board.getMark(tempRow, col) ==' ') {
					blockRow = tempRow;
					blockCol = col;
					blockable = true;
				}
			}
		}
	}
	
	if(blockable == false){
			int mark_count = 0;
			for (row = 0;row < 3; row++) {
				if (board.getMark(row, row) == opponent.mark)
					mark_count++;
				if(board.getMark(row, row)== ' ') 
					tempRow = row;
				
				if(mark_count == 2 && board.getMark(tempRow, tempRow) ==' ') {
					blockRow = tempRow;
					blockCol = tempRow;
					blockable = true;
				}
			}
		}
	if(blockable == false){
		int mark_count = 0;
		for (row = 0;row < 3; row++) {
			if (board.getMark(row,2 - row) == opponent.mark)
				mark_count++;
			if(board.getMark(row, 2-row)== ' ') 
				tempRow = row;
			
			if(mark_count == 2 && board.getMark(tempRow, 2-tempRow) ==' ') {
				blockRow = tempRow;
				blockCol = 2-tempRow;
				blockable = true;
			}
		}
	}
	
	
	
	
	}
}
