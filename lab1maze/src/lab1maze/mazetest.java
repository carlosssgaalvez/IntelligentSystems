package lab1maze;
import java.util.Random;
public class mazetest {
	
	public static int numRandom(int n) {
		Random aleatorio = new Random();
		int nRandom = aleatorio.nextInt(n);
		return nRandom;
		}
	public static void createMatrix(char  [][] maze,int row,int col,int percObs) {
		//colocamos G
		int goalrow =numRandom(row);
		int goalcol= numRandom(col);
		maze[goalrow][goalcol]='G';
		
		//colocamos I
		int inirow,inicol;
		do {
		inirow =numRandom(row);
		inicol= numRandom(col);
		maze[inirow][inicol]='I';
		}while(inirow==goalrow && goalcol==inicol);
		
		//colocamos #
		int numObs=row*col*percObs/100;
		
		int obsrow, obscol;
		while(numObs>0) {
			
			obsrow =numRandom(row);
			obscol= numRandom(col);
			if(maze[obsrow][obscol]!='G' && maze[obsrow][obscol]!='I' && maze[obsrow][obscol]!='#') {
				maze[obsrow][obscol]='#';
				numObs--;
			}
			
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(maze[i][j]!='G' && maze[i][j]!='I' && maze[i][j]!='#') {
					maze[i][j]=' ';
				}
			}
		}
	}
	
	public static void showMatrix(char [][] maze,int row,int col) {
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(maze[i][j]);
				
			}
			System.out.print("\n");
		}
	}
	public static void main(String[] args) {
		int row=60,col=80;
		int percObs = 30;
		
		char [][] maze= new char[row][col];
		createMatrix(maze,row,col,percObs);
		showMatrix(maze,row,col);
		

		
	}


	

}
	
