import sudoku.*;

public class TestSudoku {

	public static void main(String[] args) {

		Sudoku s = new Sudoku(1);
		
		s.printSudoku();
		s.printMissingValues();
		System.out.println();
		SudokuIndividual ind1 = new SudokuIndividual(s);
		ind1.printIndividual();
		SudokuIndividual ind2 = new SudokuIndividual(s);
		ind2.printIndividual();
		SudokuIndividual ind3 = new SudokuIndividual(s);
		ind3.printIndividual();
		SudokuIndividual ind4 = new SudokuIndividual(s);
		ind4.printIndividual();

	}

}