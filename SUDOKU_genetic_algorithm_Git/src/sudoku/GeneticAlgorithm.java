package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {
	private List<SudokuPopulation> poblaciones;
	private static final Random rnd = new Random();
	public GeneticAlgorithm(Sudoku s) {
		poblaciones= new ArrayList<>();
		poblaciones.add(new SudokuPopulation(s));
	}
	
	private void algorithm(Sudoku s) {
		int p=0;
		poblaciones.get(p).addIndividuals(s);
		SudokuIndividual s1 = eligeIndividual(p);
		int randomMode = rnd.nextInt(3);
		if(randomMode == 0) { // se queda igual
			poblaciones.get(1).getPopulation().add(s1);
		} else if(randomMode == 1){ //mutation
			SudokuIndividual nuevo = new SudokuIndividual(s1);
			poblaciones.get(1).getPopulation().add(nuevo);
		}else { //crossover
			SudokuIndividual s2 = eligeIndividual(p);
			SudokuIndividual nuevo = new SudokuIndividual(s1,s2);
			poblaciones.get(1).getPopulation().add(nuevo);
		}
	}
	
	
	public SudokuIndividual eligeIndividual(int p) {
		int randomIndex;
		
		int length= poblaciones.get(p).getTotalFitness();
		int cnt=0,i = 0;
		boolean encontrado = false;
		randomIndex = rnd.nextInt(length);
		while(!encontrado) {
			cnt += poblaciones.get(p).getPopulation().get(i).getFitness();
			if(randomIndex < cnt) {
				encontrado = true;
			}
			if(!encontrado) {
				i++;
			}
		}
		return poblaciones.get(p).getPopulation().get(i);
	}
	
}
