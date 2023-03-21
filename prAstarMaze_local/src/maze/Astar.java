package maze;

import java.util.List;
import java.util.ArrayList;

public class Astar extends Maze {
	
	private List<Node> closedSet;
	private List<Node> openSet;
	private List<Node> parent;
	
	public Astar() {
		super();
		closedSet = new ArrayList<>();
		openSet = new ArrayList<>();
		parent = new ArrayList<>();
	}
	
	public void fillOpenSet(Node e) {
		
		if(maze maze[i][j]!='#' && !closedSet.contains(e)) {
			
		}
					openSet.add(e);
				
			
		
		
	}
	public void principal() {
		Node e;
		int i=0,j=0;
		while(openSet.isEmpty()) {
			j=0;
			while(j<COLS) {
				if( maze[i][j]=='I') {
					e=new Node(i,j);
					openSet.add(e);
					j++;
				}
			}
			i++;
		}
				
			
		fillOpenSet(e);
		while(!openSet.isEmpty()) {
			
		}
	}
	
	private boolean isSurrounded(int i, int j) {
		boolean is = false;
		if(maze[i-1][j] == '#' && maze[i][j-1] == '#' && maze[i][j+1] == '#' && maze[i+1][j] == '#')
			is = true;
		return is;
	}
		
}
