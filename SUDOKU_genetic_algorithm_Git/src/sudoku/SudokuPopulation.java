package sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuPopulation {
	
	private int populationSize = 50;
	private List<SudokuIndividual> population; // Population of Sudokus that have in common the assigned cells with numbers and each one a different solution proposal 
	private int totalFitness;
	
	public SudokuPopulation(Sudoku s) {
		population = new ArrayList<>();
		totalFitness = sumUpAllFitness();
		
	}
	
	public void addIndividuals(Sudoku s) {
		for (int i = 0; i < populationSize; ++i)
			population.add(new SudokuIndividual(s));
	}
	
	public List<SudokuIndividual> getPopulation() {
		return population;
	}

	private int sumUpAllFitness() {
		int v = 0;
		for (int i = 0; i < populationSize; ++i)
			totalFitness += population.get(i).getFitness();
		return v;
	}
	public int getTotalFitness(){
		return totalFitness;
	}
	public int getPopulationSize(){
		return populationSize;
	}
}
