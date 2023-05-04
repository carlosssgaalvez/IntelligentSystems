package sudoku;

public class Sudoku {
	
	private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";
	
	private int[][] board;
	private int[][] missingValues;
	private final int SIZE = 9;
	
	public Sudoku(int op) {
		board = createMatrix(op);
		missingValues = getMissingValues();
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
	
	private int[][] getMissingValues() { // 
		int[][] other = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				other[i][j] = j+1;
			}
		}
		int v;
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				v = board[i][j];
				if (v != 0) 
					other[i][v-1] = 0;
			}
		}
		return other;
	}
	
	public void printMissingValues() {
		System.out.println();
		System.out.println("Missing values: ");
		System.out.println("--------------- ");
		for(int i = 0; i < SIZE; ++i) {
			System.out.print("Row " + i + ": { ");
			for(int j = 0; j < SIZE; ++j) {
				if (missingValues[i][j] != 0)
				System.out.print(missingValues[i][j] + " ");
			}
			System.out.println("}");
		}
	}
	
	public void printSudoku() {
		System.out.println(ANSI_CYAN + " ----------------------- " + ANSI_RESET);
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				if(j == 0)
					System.out.print(ANSI_CYAN + "| " + ANSI_RESET);
				System.out.print(board[i][j] + " ");
				if((j+1) % 3 == 0)
					System.out.print(ANSI_CYAN + "| " + ANSI_RESET);
			}
			System.out.println();
			if((i+1) % 3 == 0)
				System.out.println(ANSI_CYAN + " ----------------------- " + ANSI_RESET);				
		}
	}
	
	
	
}
