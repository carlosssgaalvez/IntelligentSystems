import maze.*;

public class TestMaze {

	public static void main(String[] args) {

		Maze maze = new Astar();
		
		maze.generateMaze();
		maze.printMaze();

	}

}
