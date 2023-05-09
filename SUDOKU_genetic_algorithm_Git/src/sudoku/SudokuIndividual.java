package sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuIndividual {
	
	
	private int[][] matrix;
	private final int SIZE = 9;
	public SudokuIndividual(Sudoku s) {
		matrix=generateIndividual(s);
		
	}
	
	private int[][] generateIndividual(Sudoku s){
		int [][] relleno = s.getBoard();
		ArrayList<Integer>[] missings = s.getMissingValues();
		List<Integer> valuesSelected;
		int randomIndex;
		int length;
		for(int i=0;i<SIZE;i++) {
			valuesSelected = new ArrayList<>();
			for(int j=0;j<SIZE;j++) {
				if(relleno[i][j]==0) {
					length=missings[i].size();
					do {
						randomIndex= (int)Math.floor(Math.random()*length);
					}while(valuesSelected.contains(missings[i].get(randomIndex)));
					valuesSelected.add(missings[i].get(randomIndex));
					relleno[i][j]=missings[i].get(randomIndex);
				}
			}
		}
		
		return relleno;
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
