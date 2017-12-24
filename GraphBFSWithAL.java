// Do Breadth First Search of a given graph using a queue.

import java.util.*;

public class GraphBFSWithAL{
    private int v;
    
    public class Node {
        int val;
        
        public Node ( int i) {
            val=i;
        }
        
        public int getVal(){
            return val;
        }
        
    }
    
    
    
    public LinkedList <Node> al[];
    
    GraphBFSWithAL () {
        v = 0;
        al = null;
    }
    
    GraphBFSWithAL ( int i ) {
        v = i;
        al = new LinkedList[v];
        
        for ( int j=0; j<v ; j++) {
            al[j] = new LinkedList <Node> ();
        }
    }
    
    public void addVertice ( int i, int j) {
        Node n = new Node (j);
        al[i].add(n);
        //System.out.println ("adding  " + n.getVal() );
    }
    
    public void BFSutil ( int i, boolean visited[]){
        
        LinkedList <Node> q = new LinkedList <Node>();
        
        visited[i] = true;
        Node n = new Node (i);
        q.add(n);
        
        while ( q.size() !=0 ) {
            
            n = q.poll();
            System.out.print (n.val + " ");
            
            Iterator<Node> itr = al[n.getVal()].listIterator();
            
            while ( itr.hasNext() ) {
            
                Node n1 = itr.next();
                //System.out.println ( "Next node " + n1.getVal() );
                
                if ( ! visited[n1.getVal()] ) {
                    //System.out.println ("adding  " + n1.getVal() );
                    visited[n1.getVal()] = true;
                    q.add(n1);
                }
            }
        }
        System.out.println("");
        
    }
    
    public void BFS ( int i) {
        boolean visited [] = new boolean [v];
        BFSutil (i, visited);
    }
    
     public static void main(String []args){
        GraphBFSWithAL g = new GraphBFSWithAL (4);
        
    
        
        g.addVertice(0, 1);
        g.addVertice(0, 2);
        g.addVertice(1, 2);
        g.addVertice(2, 0);
        g.addVertice(2, 3);
        g.addVertice(3, 3);
        
        
        System.out.println ("BFS for the graph is :");
       
        g.BFS(2);
        
        
        
     }
}
