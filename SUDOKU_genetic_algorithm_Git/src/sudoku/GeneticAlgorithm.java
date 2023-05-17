package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {
	
	private List<SudokuPopulation> poblaciones;
	private final int SIZE = 9;	
	
	private static final Random rnd = new Random();
	public GeneticAlgorithm(Sudoku s) {
		poblaciones = new ArrayList<>();
		poblaciones.add(new SudokuPopulation());
	}
	
	public void algorithm(Sudoku s) {
		
		int p = 0;	
		int populationSize = poblaciones.get(p).getPopulationSize();
		
		poblaciones.get(p).addIndividuals(s);
		poblaciones.get(p).getTotalFitness();
		poblaciones.get(p).showPopulation();
		
		while (isSolved(poblaciones.get(p)) == -1 && p < 150) {
			for (int i = 0; i < populationSize; ++i) {
				
				int randomMode = rnd.nextInt(10);
				SudokuPopulation poblacion = new SudokuPopulation();
				poblaciones.add(poblacion);
				SudokuIndividual s0 = eligeIndividual(p);
			
				if (randomMode < 2) { // the individual remains the same
					poblaciones.get(p+1).getPopulation().add(s0);
					
				} else if (randomMode == 2) { // mutation is applied to the individual
					SudokuIndividual nuevo = new SudokuIndividual(s,s0);
					poblaciones.get(p+1).getPopulation().add(nuevo);
					
				} else if (randomMode >= 3) { // crossover is applied to the individual
					SudokuIndividual s2 = eligeIndividual(p);
					
					int row;
					int [][] matrix = new int[SIZE][SIZE];
					row = 1 + rnd.nextInt(SIZE);
					for (int c = 0; c < row; ++c)
						for (int j = 0; j < SIZE; ++j)
							matrix[c][j] = s0.getMatrix()[c][j];
				
					for (int l = row; l < SIZE; ++l)
						for (int m = 0; m < SIZE; ++m) 
							matrix[l][m] = s2.getMatrix()[l][m];

					SudokuIndividual ind1 = new SudokuIndividual(matrix);
					poblaciones.get(p+1).getPopulation().add(ind1);
					
					int [][] matrix2 = new int[SIZE][SIZE];
					for(int c = 0; c < row; ++c)
						for (int j = 0; j < SIZE; ++j)
							matrix2[c][j] = s2.getMatrix()[c][j];
							
					for (int l = row; l < SIZE; ++l)
						for(int m = 0; m < SIZE; ++m) 
							matrix2[l][m] = s0.getMatrix()[l][m];
							
					SudokuIndividual ind2 = new SudokuIndividual(matrix2);
					poblaciones.get(p+1).getPopulation().add(ind2);
				
					++i;
				}
			}
			++p;
			poblaciones.get(p).getTotalFitness();
		}
	
		poblaciones.get(p).showPopulation();
		int n = isSolved(poblaciones.get(p));
		if (n != -1) {
			System.out.println("SOLUCION CORECTA:");
			poblaciones.get(p).getPopulation().get(n).printIndividual();
		}		
	}
	
	private int isSolved(SudokuPopulation sp) {
		boolean ok = false;
		int cnt = 0;
		while(!ok && cnt < sp.getPopulation().size()) {
			if(sp.getPopulation().get(cnt).isSolved())
				ok = true;	
			++cnt;
		}	
		if (!ok)
			cnt = -1;
		return cnt;
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
