package maze;

import java.util.ArrayList;
import java.util.List;

public class Node extends Maze{
	
	private int row;
	private int col;
	private int g;
	private int f;
	private ArrayList<Node> neighbours;
	
	public Node(int r, int c,int g) {
		row = r;
		col = c;
		this.g=g;
		f=fillF();
		neighbours=fillNeighbours();
		
	}
	
	public ArrayList<Node> getNeighbours() {
		return neighbours;
	}

	public ArrayList<Node> fillNeighbours() {
			ArrayList<Node> n=new ArrayList<>();
			int i=getRow();
			int j= getCol();
			int g=getG();
			Node aux;
			if(j+1<COLS){               //coge el vecino de la derecha
				aux=new Node(i,j+1,g);
				if(maze[i][j+1]!='#') {
					n.add(aux);
				}
			}
			if(j-1>=0){                 //coge el vecino de la izquierda
				aux=new Node(i,j-1,g);
				if(maze[i][j-1]!='#') {
					n.add(aux);
				}
			}
			if(i+1<ROWS){                //coge el vecino de abajo
				aux=new Node(i+1,j,g);
				if(maze[i+1][j]!='#') {
					n.add(aux);
				}
			}
			if(i-1>=0){                  //coge el vecino de arriba
				aux=new Node(i-1,j,g);
				if(maze[i-1][j]!='#') {
					n.add(aux);
				}
			}
			
			return n;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public int getG() {
		return g;
	}
	public void setG(int newValue) {
		g=newValue;
	}
	public int fillF() {
		return (getG() + getH());
	}
	public void setF(int n) {
		f=n;
	}
	public int getF() {
		return f;
	}
	public int getH() {
		int distance,igoal,jgoal;
		igoal=getRowG();
		jgoal=getColG();
		distance = Math.abs(igoal- getRow())+ Math.abs(jgoal - getCol());
		return distance;
	}
	
}
