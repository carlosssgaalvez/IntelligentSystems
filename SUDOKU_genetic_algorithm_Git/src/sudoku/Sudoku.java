package sudoku;

public class Sudoku {
	
	private int[][] board;
	private final int SIZE = 9;
	
	public Sudoku(int op) {
		board = createMatrix(op);
	}
	
	private int[][] createMatrix(int op) {
		int[] array;
		int [][] matrix = new int[SIZE][SIZE];
		
		Creator c = new Creator();
		array = c.create(op);
		
		int cnt = 0;
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				matrix[i][j] = array[cnt];
				++cnt;
			}
		}
		
		return matrix;
	}
	
	public void printSudoku() {
		System.out.println(" _______________________");
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				if(j == 0)
					System.out.print("| ");
				System.out.print(board[i][j] + " ");
				if((j+1) % 3 == 0)
					System.out.print("| ");
			}
			System.out.println();
			if((i+1) % 3 == 0)
				System.out.println(" _______________________");
		}
	}
	
}
