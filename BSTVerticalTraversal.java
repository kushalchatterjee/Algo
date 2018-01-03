// Recursive Java program for vertical traversal for BST
 
import java.util.*;
import java.util.Map.Entry;

public class BSTVerticalTraversal
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
        
        printDiagonalUtil (root.left, dS, d-1 ); // Traverse Left child, increase diagonal depth by 1
        
        printDiagonalUtil (root.right, dS, d+1 ); // Traverse right child, keep diagonal depth same
        
    }
    public static void main ( String [] args ) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
         
        printDiagonal(root);
        
    }
}
