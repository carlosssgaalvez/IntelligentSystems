package maze;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Astar extends Maze {
	
	private Set<Node> closedSet;
	private Set<Node> openSet;
	private Map<Node,Integer> parent;

	
	public Astar() {
		super();
		closedSet = new HashSet<>();
		openSet = new HashSet<>();
		parent = new HashMap<>();
	}
	
	

	public void addOpenSet(Node e) {
	    if (openSet.isEmpty()) {
	        openSet.add(e);
	    } else {
	        openSet.add(e);
	    }
	}
	
	public boolean isGoal(Node e) {
		return maze[e.getRow()][e.getCol()]=='G';
	}
	public void principal() {
		Node init = new Node(getRowI(),getColI(),0);
		Node current;
		openSet.add(init);
		int tentative_g;
		
		while(!openSet.isEmpty()) {
			current =openSet.get(0);
			if(isGoal(current)) {
				//return reconstruct_path(parent,current);
			}
			openSet.remove(0);
			closedSet.add(current);
			for(int i=0;i<current.getNeighbours().size();i++) {
				if(!closedSet.contains(current.getNeighbours().get(i))) {
					tentative_g= current.getG()+1;
					
					if(!openSet.contains(current.getNeighbours().get(i)) || tentative_g < current.getNeighbours().get(i).getG()){
						//parent[neighbour]=current;
						current.getNeighbours().get(i).setG(tentative_g);
						//current.getNeighbours().get(i).
						
						
					}
				}
			}
			
		}
				
	}	
	
		
}
