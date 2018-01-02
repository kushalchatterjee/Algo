//Find the rout for a Mouse in the Maze
//The Maze is represented in adjacency matrix

public class MouseInMaze {
    public static int N = 4;
    
    public static boolean findMaze ( int [][] maze, int [][] sol, int x, int y) {
        
        if ( x == N-1 && y == N-1  ){ // destination reached
            sol[x][y] = 1; // Add the last node to solution
            return true;
        }
        
        if ( isSafe (x,y, maze) == true) {
            sol[x][y] = 1;
            
            System.out.println("x :" +x + "y :" + y);
            //recursively move towards right
            if (findMaze ( maze, sol, x+1, y) == true)
                return true;
                
            //recursively move towards left
            if (findMaze ( maze, sol, x, y+1) == true)
                return true;
            
            // Backtrack
            sol[x][y]=0;
            return false; 
            
        }
        return false;
        
    }
    
    public static boolean isSafe (int x, int y, int [][] maze) {
        if ( x >= 0 && x < N && y >= 0 && y < N && maze[x][y]==1){
            return true;
        }
        else 
            return false;
    }
    
    public static void printSolution (int [][] sol) {
        for ( int i=0; i< N; i++){
            for ( int j = 0; j<N; j++) {
                System.out.print (sol[i][j]+" " );
            }
            System.out.println ("");
        }
        System.out.println ("");
    }
    
    /* Driver program to test above functions */
    public static void main(String args[]) {
        
        int maze [][]  =  {{1, 0, 0, 0},
                             {1, 1, 0, 1},
                             {0, 1, 0, 0},
                             {1, 1, 1, 1}};
        
        int sol[][]  =  { {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}};
        
        
        if ( findMaze ( maze, sol, 0, 0) == false) {
            System.out.println ("Maze doesn't exist");
        } else {
            printSolution(sol);
        }
        
    }
}
