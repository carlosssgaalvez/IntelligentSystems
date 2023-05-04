package sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuPopulation {
	
	private List<Sudoku> population; // Population of Sudokus that have in common the assigned cells with numbers and each one a different solution proposal 
	private Sudoku sudoku;
	public Sudoku solved;
	
	public SudokuPopulation(Sudoku s) {
		population = new ArrayList<>();
		addIndividual(s);
	}
	
	public void addIndividual(Sudoku s) {
		population.add(new Sudoku(1));
	}
	
}
