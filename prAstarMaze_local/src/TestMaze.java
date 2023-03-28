
import maze.*;

public class TestMaze {

	public static void main(String[] args) {

		Astar maze = new Astar();
		maze.generateMaze();
		maze.printMaze();
		maze.printPath();
		
    }
	
}
