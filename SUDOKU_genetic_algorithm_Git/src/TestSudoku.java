import java.io.FileWriter;
import java.io.IOException;

import sudoku.*;

public class TestSudoku {
	
	private final static int SIZE = 9;

	public static void main(String[] args) throws IOException {

		Sudoku s = new Sudoku(1);
		
		s.printSudoku();
		s.printMissingValues();
		System.out.println();
		GeneticAlgorithm algorithm = new GeneticAlgorithm(s);
		algorithm.algorithm(s);
		try {
			SudokuIndividual solution = algorithm.solvedOne;
			print(solution);
		} catch (Exception e) {
			System.out.println("No solution found.");
		}
		
	}
	
	private static void print(SudokuIndividual s) throws IOException {
		try (FileWriter output = new FileWriter ("C:\\Users\\juanm\\Documents\\GitHub\\IntelligentSystems\\SUDOKU_genetic_algorithm\\output.txt")){
			int val;
			for(int i = 0; i < SIZE; ++i) {
				for(int j = 0; j < SIZE; ++j) {
					val = s.charAt(i, j);
					output.write(val);	
				}
			output.write('\n');
			}
		}
	}

}