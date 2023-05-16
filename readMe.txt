The program simulates a magical corn maze where Kenny, the main character, needs to find his way to the exit before his phone's battery dies. 
The maze contains teleportation pads represented by digits, allowing Kenny to jump to other matching digit squares within the maze.
However, some squares are invalid and cannot be walked on. Kenny starts at the bottom left corner and must navigate through the maze using only up, down, left, and right 
movements.

The program provides a solution using backtracking to solve the maze. It reads input from text files containing different maze configurations. Each maze is represented 
by a 2D array of characters, including valid and invalid squares, teleportation pads, and the exit square. The goal is to implement the solveMagicMaze method in the MagicMaze
class, which returns a boolean value indicating whether Kenny successfully escaped the maze or not.

Input: The program takes input from text files containing maze configurations. Each maze file represents a different maze with varying numbers of rows and columns. 
The file name, number of rows, and number of columns are provided as command-line arguments when running the program.

Output: The program provides a boolean value as the output. If the value is true, it means Kenny successfully solved the maze and reached the exit before his phone's 
battery died. If the value is false, it means Kenny was unable to find the exit within the time constraint.
