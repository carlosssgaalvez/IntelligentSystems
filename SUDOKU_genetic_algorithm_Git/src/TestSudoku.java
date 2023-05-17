import sudoku.*;

public class TestSudoku {

	public static void main(String[] args) {

		Sudoku s = new Sudoku(1);
		
		s.printSudoku();
		s.printMissingValues();
		System.out.println();
		GeneticAlgorithm algorithm = new GeneticAlgorithm(s);
		algorithm.algorithm(s);
		System.out.println();
		
		
		
	}

}