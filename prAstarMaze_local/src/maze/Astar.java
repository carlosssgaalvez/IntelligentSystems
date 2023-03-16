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
	
	public void fillClosedSet() {
		Node e;
		for(int i = 0; i < ROWS; ++i) {
			for(int j = 0; j < COLS; ++j) {
				if(maze[i][j] != ' ') {
					if(!isSurrounded(i, j)) {
						e = new Node(i, j);
						closedSet.add(e);
					}
				}
			}
		}
	}
	
	private boolean isSurrounded(int i, int j) {
		boolean is = false;
		if(maze[i-1][j] == '#' && maze[i][j-1] == '#' && maze[i][j+1] == '#' && maze[i+1][j] == '#')
			is = true;
		return is;
	}
		
}
