package sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuPopulation {
	
	private int populationSize = 50;
	private List<SudokuIndividual> population; // Population of Sudokus that have in common the assigned cells with numbers and each one a different solution proposal 
	private int totalFitness=0;
	
	public SudokuPopulation() {
		population = new ArrayList<>();
	
		
	}
	
	public void addIndividuals(Sudoku s) {
		for (int i = 0; i < populationSize; ++i)
			population.add(new SudokuIndividual(s));
	}
	
	public List<SudokuIndividual> getPopulation() {
		return population;
	}

	public void sumUpAllFitness() {
		
		for (int i = 0; i < populationSize; ++i)
			totalFitness += population.get(i).getFitness();
	
	}
	public int getTotalFitness(){
		return totalFitness;
	}
	public int getPopulationSize(){
		return populationSize;
	}
	
	public void showPopulation() {
		System.out.println("POBLACION 1");
		
		for(int i=0;i<populationSize;i++) {
			population.get(i).printIndividual();
		}
		System.out.println("------------------------");
	}
}
