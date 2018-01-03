// Recursive Java program for diagonal traversal for BST
 
import java.util.*;
import java.util.Map.Entry;

public class BSTDiagonalTraversal
{
    public static class Node {
        int data;
        Node left;
        Node right;
        
        public Node ( int i) {
            data = i;
            left = null;
            right = null;
        }
    }
    
    
    public static void printDiagonal (Node root) {
        HashMap < Integer, Vector<Integer>> dS = new HashMap<> ();
        
        
        printDiagonalUtil (root, dS, 0);
        
        for ( Entry<Integer, Vector<Integer>> entry : dS.entrySet()) {
            System.out.println(entry.getValue());   
        }
        
        
    }
    
    public static void printDiagonalUtil (Node root, HashMap < Integer, Vector<Integer>> dS, int d ) {
        
        if ( root == null ){
            return;
        }
        
        Vector<Integer> k = dS.get(d); // Get the Vector in diagonal depth d
        
        if ( k == null ) {
            k = new Vector<> ();
            k.add(root.data);
        }
        else {
            k.add(root.data);
        }
        
        dS.put(d, k);
        
        printDiagonalUtil (root.left, dS, d+1 ); // Traverse Left child, increase diagonal depth by 1
        
        printDiagonalUtil (root.right, dS, d ); // Traverse right child, keep diagonal depth same
        
    }
    public static void main ( String [] args ) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
         
        printDiagonal(root);
        
    }
}
