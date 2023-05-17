package sudoku;

import java.util.*;

public class SudokuIndividual {
	
	private int[][] matrix;
	private final int SIZE = 9;
	private int fitness;
	private final int GOAL = 162;
	
	private static final Random rnd = new Random();
	
	public SudokuIndividual(Sudoku s) {
		matrix = generateIndividual(s);
		fitness = calcFitness();
	}
	
	// MUTATION
	public SudokuIndividual(Sudoku s, SudokuIndividual s1) {
		matrix = generateMutation(s, s1);
		fitness = calcFitness();
	}
	
	// CROSS-OVER
	public SudokuIndividual(int [][] matrix) {
		this.matrix = matrix;
		fitness = calcFitness();
	}
	
	
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	private int[][] generateMutation(Sudoku s, SudokuIndividual s1){
		// part of the matrix that remains the same
		int randomRow = rnd.nextInt(SIZE);
		
		int[][] filled = new int[SIZE][SIZE];
		for(int i = 0; i < SIZE; ++i)
			for(int j = 0; j < SIZE; ++j)
				filled[i][j] = s.getBoard()[i][j];
		ArrayList<Integer>[] missings = s.getMissingValues();
		List<Integer> valuesSelected = new ArrayList<>();
		int randomIndex;
		int length;
		
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if (i == randomRow) {
					if (filled[randomRow][j] == 0) {
						length = missings[i].size();
						do {
							randomIndex = rnd.nextInt(length);
						} while (valuesSelected.contains(missings[i].get(randomIndex)));
						valuesSelected.add(missings[i].get(randomIndex));
						filled[i][j] = missings[i].get(randomIndex);
					}
				}
			}
		}
		return filled;
	}
	

	private int[][] generateIndividual(Sudoku s){
		int[][] filled = new int[SIZE][SIZE];
		for(int i = 0; i < SIZE; ++i)
			for(int j = 0; j < SIZE; ++j)
				filled[i][j] = s.getBoard()[i][j];
		ArrayList<Integer>[] missings = s.getMissingValues();
		List<Integer> valuesSelected;
		int randomIndex;
		int length;
		for (int i = 0; i < SIZE; i++) {
			valuesSelected = new ArrayList<>();
			for(int j = 0; j < SIZE; j++) {
				if (filled[i][j] == 0) {
					length = missings[i].size();
					do {
						randomIndex = rnd.nextInt(length);
					} while (valuesSelected.contains(missings[i].get(randomIndex)));
					valuesSelected.add(missings[i].get(randomIndex));
					filled[i][j] = missings[i].get(randomIndex);
				}
			}
		}
		return filled;
	}
	
	public void printIndividual() {
		System.out.println(" ----------------------- ");
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				if(j == 0)
					System.out.print("| ");
				System.out.print(matrix[i][j] + " ");
				if((j+1) % 3 == 0)
					System.out.print("| ");
			}
			System.out.println();
			if((i+1) % 3 == 0)
				System.out.println(" ----------------------- ");				
		}
		System.out.println("Fitness = "+ fitness);
	}
	
	private int calcFitness() {
		int v = 0;
		v = fitnessOfRegion() + fitnessOfColumns();
		return v;
	}
	
	private int fitnessOfRegion() {
		int v = 0;
		int cntI, cntJ;
		int posicionI, posicionJ;
		boolean is;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				is = true;
				if (i < 3) {
					posicionI = 3;
				} else if (i < 6) {
					posicionI = 6;
				} else {
					posicionI = 9;
				}
				if (j < 3) {
					posicionJ = 3;
				} else if (j < 6) {
					posicionJ = 6;
				} else {
					posicionJ = 9;
				}
				cntI = posicionI-3;
				
				while (is && cntI < posicionI) {
					cntJ = posicionJ-3;
					while (is && cntJ < posicionJ) {
						if (!(i == cntI && j == cntJ)) {
							if (matrix[i][j] == matrix[cntI][cntJ]) {
								is = false;
							}
						}						
						cntJ++;
					}			
					cntI++;
				}
				if (is)
					++v;
			}
		}
		return v;
	}
	
	private int fitnessOfColumns() {
		int v = 0;
		boolean is;
		int cnt;
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				is = false;
				cnt = 0;
				while (!is && cnt < SIZE) {
					if (i != cnt && matrix[i][j] == matrix[cnt][j])
						is = true;
					++cnt;
				}
				if (!is)
					++v;
			}
		}
		return v;
	}
	
	public int getFitness() {
		return calcFitness();
	}
	
	public boolean isSolved() {
		return (fitness == GOAL);
	}
	
}
