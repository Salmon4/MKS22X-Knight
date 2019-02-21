public class Driver{
	public static void main(String[] args){

		KnightBoard board1 = new KnightBoard(1,1);
		KnightBoard board2 = new KnightBoard(2,2);
		KnightBoard board3 = new KnightBoard(3,3);
		KnightBoard board4 = new KnightBoard(4,4);
		KnightBoard board5 = new KnightBoard(5,5);
		KnightBoard board6 = new KnightBoard(6,6);
		KnightBoard board7 = new KnightBoard(7,7);
		KnightBoard board8 = new KnightBoard(8,8);
		//System.out.println(board5.toString());
		//System.out.println(board5.solve(3,3));
		//System.out.println(board5.toString());
		//System.out.println(board6.countSolutions(0,0));
		System.out.println(board5.toStringOutGoingMoves());
		/**
		String time;
		System.out.println("SOLVE: (from (0, 0))\n");
		for (int r = 1; r < 100; r++) {
			KnightBoard b = new KnightBoard(r, r);
			long startTime = System.nanoTime();
			try {
				if (r == 51 || r == 52)
					time = "skipped";
				else if (b.solve(0, 0))
					time = Math.round((System.nanoTime()-startTime)/10000.)/100.+"ms";
				else
					time = "unsolvable";
				System.out.printf("\t%dx%d:\t%s%n", r, r, time);
			} catch (StackOverflowError e) {
				System.out.printf("\t%dx%d:\tstack overflow%n", r, r);
				break;
			}
		}
		System.out.println("\nCOUNT SOLUTIONS: (from (0, 0))\n");
		for (int r = 1; r < 6; r++) {
			for (int c = r; c < 6; c++) {
				KnightBoard b = new KnightBoard(r, c);
				long startTime = System.nanoTime();
				try {
					int n = b.countSolutions(0, 0);
					time = Math.round((System.nanoTime()-startTime)/10000.)/100.+"ms";
					System.out.printf("\t%dx%d:\t%d solutions\t\t%s%n", r, c, n, time);
				} catch (StackOverflowError e) {
					System.out.printf("\t%dx%d:\tstack overflow%n", r, c);
					break;
				}
			}
		}
		**/
	}
}
