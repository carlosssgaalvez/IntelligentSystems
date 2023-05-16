package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {
	private List<SudokuPopulation> poblaciones;
	private final int SIZE=9;
	private static final Random rnd = new Random();
	public GeneticAlgorithm(Sudoku s) {
		poblaciones= new ArrayList<>();
		poblaciones.add(new SudokuPopulation());
	}
	
	public void algorithm(Sudoku s) {
		int p=0;	
		poblaciones.get(p).addIndividuals(s);
		poblaciones.get(p).sumUpAllFitness();
		poblaciones.get(p).showPopulation();
		
		
		while(isSolve(poblaciones.get(p)) == -1 && p < 1000) {
			
			int randomMode = rnd.nextInt(2);
			SudokuPopulation poblacion = new SudokuPopulation();
			poblaciones.add(poblacion);
			if(randomMode == 0) { // se queda igual
				
				
				SudokuIndividual s0;
				for(int k =0;k<poblaciones.get(p).getPopulationSize();k++) {
					s0 = eligeIndividual(p);
					poblaciones.get(p+1).getPopulation().add(s0);
				}
			} else if(randomMode == 1){ //mutation
				SudokuIndividual s1,nuevo;
				for(int k =0;k<poblaciones.get(p).getPopulationSize();k++) {
					s1 = eligeIndividual(p);
					nuevo = new SudokuIndividual(s,s1);
					poblaciones.get(p+1).getPopulation().add(nuevo);
				}
				
			}else { //crossover
				/*SudokuIndividual s4 = eligeIndividual(p);
				SudokuIndividual nuevo = new SudokuIndividual(s1,s2);
				poblaciones.get(1).getPopulation().add(nuevo);*/
			}
			p++;
			poblaciones.get(p).sumUpAllFitness();
			
		}
		poblaciones.get(p).showPopulation();
		int n = isSolve(poblaciones.get(p));
		if(n != -1) {
			System.out.println("SOLUCION CORECTA:");
			poblaciones.get(p).getPopulation().get(n).printIndividual();
		}
		
		
	}
	
	private int isSolve(SudokuPopulation sp) {
		boolean ok = false;
		int cnt = 0;
		
		
		
		while(!ok && cnt < sp.getPopulation().size()) {
			if(sp.getPopulation().get(cnt).getFitness() == 162) {
				ok = true;	
			}
			if(!ok) {
				cnt++;
			}
		}	
		
		if(!ok) {
			cnt = -1;
		}
		
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
