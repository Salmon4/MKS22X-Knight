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
				else if (board[r][c] > 9){
					ans += " " + board[r][c];
				}
				else if (board[r][c] <= 9){
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
		// checks for movement
		if (row > 1 && col > 0 && board[row-2][col-1] == 0){ // up 2 left 1
			if (solveH(row-2,col-1,level + 1)){
				return true;
			}
			board[row][col] = 0;
		}
		if (row > 1 && col < board[row].length - 1 && board[row-2][col+1] == 0){  // up 2 right 1
			if (solveH(row-2,col+1,level+1)){
				return true;
			}
			board[row][col] = 0;
		}
		if (row > 0 && col > 1 && board[row-1][col-2] == 0){ // up 1 left 2
			if (solveH(row-1,col-2,level+1)){
				return true;
			}
			board[row][col] = 0;		
		}
		if (row > 0 && col < board[row].length - 2 && board[row-1][col+2] == 0){ //up 1 right 2
			if (solveH(row-1,col+2,level+1)){
				return true;
			}
			board[row][col] = 0;
		}
		if (row < board.length - 1 && col > 1 && board[row+1][col-2] == 0){ // down 1 left 2
			if (solveH(row + 1, col - 2,level+1)){
				return true;
			}
			board[row][col] = 0;
		}
		if (row < board.length - 1 && col < board[row].length -2 && board[row + 1][col+2] == 0){ // down 1 right 2	
			if (solveH(row + 1, col + 2,level+1)){
				return true;
			}
			board[row][col] = 0;
		}
		if (row < board.length - 2 && col > 0 && board[row + 2][col-1] == 0){ // down 2 left 1
			if (solveH(row + 2, col -1, level+1)){
				return true;
			}
			board[row][col] = 0;
		}
		if (row < board.length - 2 && col < board[row].length - 1 && board[row+2][col+1] == 0){ // down 2 right 1
			if (solveH(row + 2, col + 1,level +1)){
				return true;
			}
			board[row][col] = 0;
		}
		return false;
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
