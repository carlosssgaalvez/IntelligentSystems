import sudoku.*;

public class TestSudoku {

	public static void main(String[] args) {

		Sudoku s = new Sudoku(1);
		
		s.printSudoku();
		s.printMissingValues();
		System.out.println();
		GeneticAlgorithm algoritmo = new GeneticAlgorithm(s);
		algoritmo.algorithm(s);
		System.out.println();
		
		
		
	}

}