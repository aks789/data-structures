package backtracking;

/**
 * Path from source to destination via backtracking for a Rat trapped in a maze (0,1)
 * Created by AKRITI on 4/20/2019.
 */
public class RatInMazeProblem {

    // Size of the square maze
    final int N = 4;

    // Function to find the solution path
    public boolean findSolForMaze(int maze[][], int x, int y, int sol[][]) {

        // If the coordinates of maze reach the destination then return
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }
        // Check if the curent coordinates x,y are safe to traverse
        if (isSafe(maze, x, y)) {
            // Mark the path in the solution matrix
            sol[x][y] = 1;

            // Check if rat can move one step forward
            if (findSolForMaze(maze, x + 1, y, sol)) {
                return true;
            }
            // Check if rat can move one step below
            if (findSolForMaze(maze, x, y + 1, sol)) {
                return true;
            }

            // If rat cannot move either forward or downward then backtrack from current coordinates
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    // Returns true if the current x,y coordinates of maze are valid for rat to move to
    public boolean isSafe(int[][] maze, int x, int y) {
        if (x < N && x >= 0 && y < N && y >= 0 && maze[x][y] == 1) {
            return true;
        }
        return false;
    }

    public void printSol(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solveRatInMazeProblem(int[][] maze) {
        int[][] sol = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0,}};
        if (findSolForMaze(maze, 0, 0, sol)) {
            printSol(sol);
        }
    }

    public static void main(String[] args) {
        RatInMazeProblem ratInMazeProblem = new RatInMazeProblem();
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 1, 0}};

        ratInMazeProblem.solveRatInMazeProblem(maze);
    }
}
