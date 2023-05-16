import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/* Darian Torres
 */


public class MagicMaze {
	char[][] maze;
	String name;  
	int rows;
	int cols;
	boolean [][] visited;
	//initializes file name, rows, cols, and maze
	
	
	public MagicMaze(String filename, int rows, int cols) throws FileNotFoundException{
		this.name = filename;
		this.rows = rows;
		this.cols = cols;
		this.maze = readMaze(filename, rows, cols);
		this.visited = new boolean[rows][cols];
		//printMaze();
	}
	
	
	//copied from assignment 1, try to fix and make it print out board
	//makes the player start at the bottom left of the text file but make the bottom left start
	//as [0,0]
	private char[][] readMaze(String filename, int rows, int cols) throws FileNotFoundException{
		File file= new File(filename);
		Scanner s = new Scanner(file);
		
		String row = "";
		char[][] maze = new char[rows][cols];
		
		for(int i=0;i<rows; i++) {
			if (s.hasNextLine())
				row = s.nextLine();
			for(int j = 0; j<cols; j++) {
				maze[rows-i-1][j] = row.charAt(j);
			}
		}
		
		
		s.close();
		return maze;
	}

	//runs the code
	public boolean solveMagicMaze() {
		return rsolveMagicMaze(0, 0, false);
	}
	
	private int[] getTele(char teleporterID, int row, int col) {
		int[] receiverCoords= new int[2];
		for(int i = 0; i<this.rows; i++) {
			for (int j = 0; j<this.cols; j++) {
				if(this.maze[i][j] == teleporterID && (i != row || j != col)) {
					receiverCoords[0]=i;
					receiverCoords[1]=j;
					return receiverCoords;
				}
			}
		}
		return null;
	}
	
	//sees if there an integer in the current cell
	private boolean isInteger(char c) {
		try {
			Integer.parseInt(Character.toString(c));
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
		
	}
	
	private boolean rsolveMagicMaze(int row, int col, boolean teleported){
		//see if out of bounds
		if(row<0 || col<0 || row >=this.rows || col >=this.cols)
			return false;
		
		this.visited[row][col] = true;
		
		//takes current sell
		char curCell = this.maze[row][col];
		
		//System.out.println(curCell);
		
		//on the exit!
		if (curCell == 'X')
			return true; 
		
		//if we are on a wall
		if (curCell == '@')
			return false;
		
		//checks if we are on a teleporter and if we just teleporter
		if (isInteger(curCell) == true && teleported != true) {
			char teleporterID = curCell;
			int[] receiverCoord = getTele(teleporterID, row, col);
			
			//if we find the other other teleporter, teleport to the next teleporter
			if(receiverCoord != null && rsolveMagicMaze(receiverCoord[0], receiverCoord[1], true))
				return true;
		}
		
		
		//checks if we can move
		if(row+1<this.rows)
			if(!this.visited[row+1][col] && rsolveMagicMaze(row+1, col, false))
				return true;
		if(col+1<this.cols)
			if(!this.visited[row][col+1] && rsolveMagicMaze(row, col+1, false))
				return true;
		if(row-1>=0)
			if(!this.visited[row-1][col] && rsolveMagicMaze(row-1, col, false))
				return true;
		if(col-1>=0)
			if(!this.visited[row][col-1] && rsolveMagicMaze(row, col-1, false))
				return true;
		
		return false;
	}
	
	/*
	public void printMaze() {
		for (int i = 0; i<this.rows; i++) {
			for (int j = 0; j<this.cols; j++) {
				System.out.print(this.maze[i][j]);
			}
		System.out.println();
		}
	}
	*/
	
	
}
