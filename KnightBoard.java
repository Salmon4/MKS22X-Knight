public class KnightBoard{
	private int[][] board;
	private int[][] move;
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

		move = new int[startingRows][startingCols];
		int moveNumber = 0;
		for (int r = 0; r < board.length; r++){
				for (int c = 0; c < board[r].length; c++){
					moveNumber = 0;
					if (r > 1 && c > 0){
						moveNumber++;
					}
					if (r > 1 && c < board[r].length - 1){
						moveNumber++;
					}
					if (r > 0 && c > 1){
						moveNumber++;
					}
					if (r > 0 && c < board[r].length - 2){
						moveNumber++;
					}
					if (r < board.length - 1 && c > 1){
						moveNumber++;
					}
					if (r < board.length - 1 && c < board[r].length -2){
						moveNumber++;
					}
					if (r < board.length - 2 && c > 0){
						moveNumber++;
					}
					if (r < board.length - 2 && c < board[r].length - 1){
						moveNumber++;
					}
					move[r][c] = moveNumber;
				}
				moveNumber = 0;
		}
	}

	public String toStringOutGoingMoves(){
		String ans = "";
		for (int r = 0; r < move.length;r++){
			for (int c = 0; c < move[r].length;c++){
				ans += " " + move[r][c];
			}
			ans += "\n";
		}
		return ans;
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
			board[row-2][col-1] = 0;
		}
		if (row > 1 && col < board[row].length - 1 && board[row-2][col+1] == 0){  // up 2 right 1
			if (solveH(row-2,col+1,level+1)){
				return true;
			}
			board[row-2][col+1] = 0;
		}
		if (row > 0 && col > 1 && board[row-1][col-2] == 0){ // up 1 left 2
			if (solveH(row-1,col-2,level+1)){
				return true;
			}
			board[row-1][col-2] = 0;
		}
		if (row > 0 && col < board[row].length - 2 && board[row-1][col+2] == 0){ //up 1 right 2
			if (solveH(row-1,col+2,level+1)){
				return true;
			}
			board[row-1][col+2] = 0;
		}
		if (row < board.length - 1 && col > 1 && board[row+1][col-2] == 0){ // down 1 left 2
			if (solveH(row + 1, col - 2,level+1)){
				return true;
			}
			board[row+1][col-2] = 0;
		}
		if (row < board.length - 1 && col < board[row].length -2 && board[row + 1][col+2] == 0){ // down 1 right 2
			if (solveH(row + 1, col + 2,level+1)){
				return true;
			}
			board[row+1][col+2] = 0;
		}
		if (row < board.length - 2 && col > 0 && board[row + 2][col-1] == 0){ // down 2 left 1
			if (solveH(row + 2, col -1, level+1)){
				return true;
			}
			board[row+2][col-1] = 0;
		}
		if (row < board.length - 2 && col < board[row].length - 1 && board[row+2][col+1] == 0){ // down 2 right 1
			if (solveH(row + 2, col + 1,level +1)){
				return true;
			}
			board[row+2][col+1] = 0;
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


	public int countSolutions(int startingRow, int startingCol){
		return countSolutionsHelper(startingRow,startingCol,1,0);
		}

	public int countSolutionsHelper(int row, int col, int level, int ans){
		//System.out.println(ans);
		if (solved()){
			ans += 1;
			return ans;
		}
		for (int i = 0; i < 8; i++){
			if (i == 0){
				if (row > 1 && col > 0 && board[row][col] == 0){
					board[row][col] = level;
					ans = countSolutionsHelper(row-2,col-1,level+1,ans);
					board[row][col] = 0;
				}
			}

			if (i == 1){
				if (row > 1 && col < board[row].length - 1 && board[row][col] == 0){
					board[row][col] = level;
					ans = countSolutionsHelper(row-2,col+1,level+1,ans);
					board[row][col] = 0;
				}
			}

			if (i == 2){
				if (row > 0 && col > 1 && board[row][col] == 0){
					board[row][col] = level;
					ans = countSolutionsHelper(row-1,col-2,level+1,ans);
					board[row][col] = 0;
				}
			}

			if (i == 3){
				if (row > 0 && col < board[row].length - 2 && board[row][col] == 0){
					board[row][col] = level;
					ans = countSolutionsHelper(row-1,col+2,level+1,ans);
					board[row][col] = 0;
				}
			}

			if (i == 4){
				if (row < board.length - 1 && col > 1 && board[row][col] == 0){
					board[row][col] = level;
					ans = countSolutionsHelper(row+1,col-2,level+1,ans);
					board[row][col] = 0;
				}
			}

			if (i == 5){
				if (row < board.length - 1 && col < board[row].length -2 && board[row][col] == 0){
					board[row][col] = level;
					ans = countSolutionsHelper(row+1,col+2,level+1,ans);
					board[row][col] = 0;
				}
			}

			if (i == 6){
				if (row < board.length - 2 && col > 0 && board[row][col] == 0){
					board[row][col] = level;
					ans = countSolutionsHelper(row+2,col-1,level+1,ans);
					board[row][col] = 0;
				}
			}

			if (i == 7){
				if (row < board.length - 2 && col < board[row].length - 1 && board[row][col] == 0){
					board[row][col] = level;
					ans = countSolutionsHelper(row+2,col+1,level+1,ans);
					board[row][col] = 0;
				}
			}
		}
		return ans;
	}
/**
public int countSolutionsHelper(int row, int col, int level, int ans){
	//base case
	//System.out.println(ans);
	if (board[row][col] == 0){
		board[row][col] = level;
	}
	if (solved()){
		ans += 1;
		return ans;
	}

	//recursion
	if (row > 1 && col > 0 && board[row-2][col-1] == 0){ // up 2 left 1
		if (countSolutionsHelper(row-2,col-1,level + 1,ans) > 0){
			ans += countSolutionsHelper(row-2,col-1,level + 1,ans);
		}
		//board[row-2][col-1] = 0;
	}
	if (row > 1 && col < board[row].length - 1 && board[row-2][col+1] == 0){  // up 2 right 1
		if (countSolutionsHelper(row-2,col+1,level+1,ans) > 0){
			ans += countSolutionsHelper(row-2,col+1,level+1,ans);
		}
		//board[row-2][col+1] = 0;
	}
	if (row > 0 && col > 1 && board[row-1][col-2] == 0){ // up 1 left 2
		if (countSolutionsHelper(row-1,col-2,level+1,ans) > 0){
			ans += countSolutionsHelper(row-1,col-2,level+1,ans);
		}
		//board[row-1][col-2] = 0;
	}
	if (row > 0 && col < board[row].length - 2 && board[row-1][col+2] == 0){ //up 1 right 2
		if (countSolutionsHelper(row-1,col+2,level+1,ans) > 0){
			ans += countSolutionsHelper(row-1,col+2,level+1,ans);
		}
		//board[row-1][col+2] = 0;
	}
	if (row < board.length - 1 && col > 1 && board[row+1][col-2] == 0){ // down 1 left 2
		if (countSolutionsHelper(row + 1, col - 2,level+1,ans) > 0){
			ans += countSolutionsHelper(row + 1, col - 2,level+1,ans);
		}
		//board[row+1][col-2] = 0;
	}
	if (row < board.length - 1 && col < board[row].length -2 && board[row + 1][col+2] == 0){ // down 1 right 2
		if (countSolutionsHelper(row + 1, col + 2,level+1,ans) > 0){
			ans += countSolutionsHelper(row + 1, col + 2,level+1,ans);
		}
		//board[row+1][col+2] = 0;
	}
	if (row < board.length - 2 && col > 0 && board[row + 2][col-1] == 0){ // down 2 left 1
		if (countSolutionsHelper(row + 2, col -1, level+1,ans) > 0){
			ans += countSolutionsHelper(row + 2, col -1, level+1,ans);
		}
		//board[row+2][col-1] = 0;
	}
	if (row < board.length - 2 && col < board[row].length - 1 && board[row+2][col+1] == 0){ // down 2 right 1
		if (countSolutionsHelper(row + 2, col + 1,level +1,ans) > 0){
			ans += countSolutionsHelper(row + 2, col + 1,level +1,ans);
		}
		//board[row+2][col+1] = 0;
	}
	board[row][col] = 0;
	return ans;

}


/**
 	public int countSolutionsHelper(int row, int col, int level,int ans){
		if (solved()){
			ans += 1;
			return ans;
		}
		//System.out.println("" + ans);
		if (board[row][col] == 0){
			board[row][col] = level;

		// checks for movement
		if (row > 1 && col > 0 && board[row-2][col-1] == 0){ // up 2 left 1
			//if (countSolutionsHelper(row-2,col-1,level + 1,ans) > 0){
				ans += countSolutionsHelper(row-2,col-1,level + 1,ans);
		//	}
			board[row-2][col-1] = 0;
		}
		if (row > 1 && col < board[row].length - 1 && board[row-2][col+1] == 0){  // up 2 right 1
			//if (countSolutionsHelper(row-2,col+1,level+1,ans) > 0){
				ans += countSolutionsHelper(row-2,col+1,level+1,ans);
		//	}
			board[row-2][col+1] = 0;
		}
		if (row > 0 && col > 1 && board[row-1][col-2] == 0){ // up 1 left 2
		//	if (countSolutionsHelper(row-1,col-2,level+1,ans) > 0){
				ans += countSolutionsHelper(row-1,col-2,level+1,ans);
	//		}
			board[row-1][col-2] = 0;
		}
		if (row > 0 && col < board[row].length - 2 && board[row-1][col+2] == 0){ //up 1 right 2
		//	if (countSolutionsHelper(row-1,col+2,level+1,ans) > 0){
				ans += countSolutionsHelper(row-1,col+2,level+1,ans);
		//	}
			board[row-1][col+2] = 0;
		}
		if (row < board.length - 1 && col > 1 && board[row+1][col-2] == 0){ // down 1 left 2
	//		if (countSolutionsHelper(row + 1, col - 2,level+1,ans) > 0){
				ans += countSolutionsHelper(row + 1, col - 2,level+1,ans);
		//	}
			board[row+1][col-2] = 0;
		}
		if (row < board.length - 1 && col < board[row].length -2 && board[row + 1][col+2] == 0){ // down 1 right 2
	//		if (countSolutionsHelper(row + 1, col + 2,level+1,ans) > 0){
				ans += countSolutionsHelper(row + 1, col + 2,level+1,ans);
	//		}
			board[row+1][col+2] = 0;
		}
		if (row < board.length - 2 && col > 0 && board[row + 2][col-1] == 0){ // down 2 left 1
		//	if (countSolutionsHelper(row + 2, col -1, level+1,ans) > 0){
				ans += countSolutionsHelper(row + 2, col -1, level+1,ans);
	//		}
			board[row+2][col-1] = 0;
		}
		if (row < board.length - 2 && col < board[row].length - 1 && board[row+2][col+1] == 0){ // down 2 right 1
		//	if (countSolutionsHelper(row + 2, col + 1,level +1,ans) > 0){
				ans += countSolutionsHelper(row + 2, col + 1,level +1,ans);
		//	}
			board[row+2][col+1] = 0;
		}
		board[row][col] = 0;
	}
		return ans;
	}
	**/



}
