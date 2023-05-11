import sudoku.*;

public class TestSudoku {

	public static void main(String[] args) {

		Sudoku s = new Sudoku(1);
		
		s.printSudoku();
		s.printMissingValues();
		
		System.out.println();
		
		System.out.println("1");
		SudokuIndividual ind1 = new SudokuIndividual(s);
		ind1.printIndividual();
		System.out.println(ind1.getFitness());
		
		/*
		System.out.println("2");
		SudokuIndividual ind2 = new SudokuIndividual(s);
		ind2.printIndividual();
		
		System.out.println("3");
		SudokuIndividual ind3 = new SudokuIndividual(s);
		ind3.printIndividual();
		
		System.out.println("4");
		SudokuIndividual ind4 = new SudokuIndividual(s);
		ind4.printIndividual();
		*/
		
	}

}