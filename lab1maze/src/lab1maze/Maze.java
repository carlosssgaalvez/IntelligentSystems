package lab1maze;

import java.util.Random;

public class Maze {
	private final int row = 60;
	private final int col = 80;	
	private final int percObs = 30;
	private char[][] maze;
	
	public Maze() {
		maze = new char[row][col];    //Maze matrix
	}
	
	public void createMatrix() { //llamamos a las funciones de dentro para crear todos los elementos de la matrix
		setG();
		setI();
		setObs();
		setSpaces();
	}
	
	protected void setG() { // colocamos goal
		int goalrow =numRandom(row);
		int goalcol= numRandom(col);
		maze[goalrow][goalcol]='G';
	}
	
	protected void setI() { //colocamos I
		int inirow,inicol;
		do {
			inirow =numRandom(row);
			inicol= numRandom(col);
			maze[inirow][inicol]='I';
		}while(maze[inirow][inicol] == 'G'); // se hace mientras la casilla no este ocupada por el goal
	}
	
	protected void setObs() {
		int numObs= row*col*percObs/100; //numero de Obstaculos	
		int obsrow, obscol;
		while(numObs>0) {			
			obsrow =numRandom(row); //numero de fila al azar
			obscol= numRandom(col); //numero de columna al azar
			if(maze[obsrow][obscol]!='G' && maze[obsrow][obscol]!='I' && maze[obsrow][obscol]!='#') { //mientras no este ocupada la casilla se hace
				maze[obsrow][obscol]='#';
				numObs--;
			}
			
		}
	}
	
	protected void setSpaces() { //colocamos espacios
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(maze[i][j]!='G' && maze[i][j]!='I' && maze[i][j]!='#') { // comprobamos que no este ocupado el hueco
					maze[i][j]=' ';
				}
			}
		}
	}
	
	private int numRandom(int n) {  // metodo privado para cada vez que necesitamos numero aleatorio entre 0 y n
		int nRandom = (int)Math.floor(Math.random()*n);
		return nRandom;
	}
	
	public void showMatrix() {  //mostramos matrix
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(maze[i][j]);	
				
			}
			System.out.print("\n");  //salto de linea por cada fila terminada
		}
	}
}
