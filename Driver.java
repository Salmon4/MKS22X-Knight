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
		System.out.println(board5.toString());
		System.out.println(board5.solve(3,3));
		System.out.println(board5.toString());
	}
}
