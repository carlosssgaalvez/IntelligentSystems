package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuIndividual {
	
	private int[][] matrix;
	private final int SIZE = 9;
	
	Random rnd = new Random();
	
	public SudokuIndividual(Sudoku s) {
		matrix = generateIndividual(s);
	}

	private int[][] generateIndividual(Sudoku s){
		int [][] filled = s.getBoard();
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
					System.out.println(filled[i][j]);
				}
			}
		}
		return filled;
	}
	
	public void printIndividual() {
		System.out.println("Individual (POSIBLE SOLUCION)");
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
	}
	
}
