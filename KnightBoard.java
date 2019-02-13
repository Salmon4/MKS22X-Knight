public class KnightBoard{
	private int[][] board;
	public KnightBoard(int startingRows,int startingCols){
		if (startingRows < 0 ||startingCols < 0){
			throw new IllegalArgumentException("No Negatives");
		}
		
		board = new int[startingRows][startingCols];
		for (int r = 0; r < board.length; r++){
			for (int c = 0; c < board[r].length; c++){
				board[r][c] = 0;
			}
		}
	}

	public String toString(){
		String ans = "";
		for (int r = 0; r < board.length; r++){
			for (int c = 0; c < board[r].length; c++){
				if (board[r][c] == 0){
					ans += "  ";
				}
				if (board[r][c] > 9){
					ans += " " + board[r][c];
				}
				if (board[r][c] <= 9){
					ans += "  " + board[r][c];
				}	
			}
			ans += "\n";
		}
		return ans;
	}

	public boolean solve(int startingRow, int startingCol){
		return solveH(startingRow,startingCol, 1);
	}

	private boolean solveH(int row, int col, int level){
		if (board[row][col] == 0){				
			board[row][col] = level;
		}
		if (solved()){
			return true;
		}
		if (row > 1 && col > 0){ // up 2 left 1
			if (solveH(row+2,col-1,level + 1)){
				return true;
			}
			board[row][col] = 0;
		}
		
		
	}

	private boolean solved(){
		boolean ans = true;
		for (int r = 0; r < board.length; r++){
			for (int c = 0; c < board[r].length; c++){
				if (board[r][c] == 0){
					ans = false;
				}
			}
		}
		return ans;
	}





}
