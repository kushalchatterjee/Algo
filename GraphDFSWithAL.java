// Do Breadth First Search using adjacency list
// Makes use of recursion ( inhererent stack )
import java.util.*;

public class GraphDFSWithAL{
    private int v;
    
    public class Node {
        int val;
        
        public Node ( int i, boolean b) {
            val=i;
        }
        
        public int getVal(){
            return val;
        }
        
    }
    
    
    
    public LinkedList <Node> al[];
    
    GraphDFSWithAL () {
        v = 0;
        al = null;
    }
    
    GraphDFSWithAL ( int i ) {
        v = i;
        al = new LinkedList[v];
        
        for ( int j=0; j<v ; j++) {
            al[j] = new LinkedList <Node> ();
        }
    }
    
    public void addVertice ( int i, int j) {
        Node n = new Node (j, false);
        al[i].add(n);
    }
    
    public void DFSutil ( int i, boolean visited[]){
        
        Iterator<Node> itr = al[i].listIterator();
        
        System.out.println ( i + " ");
            
        visited[i] = true;
        
        while ( itr.hasNext() ) {
            Node n1 = itr.next();
            
            if ( ! visited[n1.getVal()] ) {
                DFSutil (n1.getVal(), visited);
            }
            
        }
    
        
    }
    
    public void DFS ( int i) {
        boolean visited [] = new boolean [v];
        DFSutil (i, visited);
    }
    
     public static void main(String []args){
        GraphDFSWithAL g = new GraphDFSWithAL (4);
        
        g.addVertice(0, 0 );
        g.addVertice(0, 1 );
        g.addVertice(0, 2 );
        g.addVertice(1, 1 );
        g.addVertice(1, 2 );
        g.addVertice(2, 2 );
        g.addVertice(2, 0 );
        g.addVertice(2, 3 );
        g.addVertice(3, 3 );
        
       
        g.DFS(2);
        
        
        
     }
}
