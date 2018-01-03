// Java program for boundary traversal for BST in anticlockwise manner
// The steps are -
// 1. Traverse left mode nodes in top down manner
// 2. Traverse leaf nodes from left to right
// 3. Traverse right most nodes in bottom up manner
// While doing so, we've got to ensure no node is printed twice
 
import java.util.*;
import java.util.Map.Entry;

public class BSTBoundaryTraversal 
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
    
    public Node root;
    
    //Function for print left boundary nodes in Top Down manner.
    public void printLeftBoundary (Node node){
        //Check node
        if (node !=null ){
            //Check if node has left child
            if ( node.left !=null) {
                System.out.println(node.data+ " "); //print before recursive call
                printLeftBoundary (node.left);
            }
            //Check if node has right child
            else if ( node.right !=null) {
                System.out.println(node.data+ " ");//print before recursive call
                printLeftBoundary (node.right);
            }
            //else do nothing. Otherwise it would print the leaf nodes.
        }
        
    }
    
    //Function for print left boundary nodes in Bottom Up manner. Print Right child before left child
    public void printRightBoundary ( Node node) {
        //Check node
        if (node !=null ){
            //Check if node has right child
            if ( node.right !=null) {
                
                printRightBoundary (node.right);
                System.out.println(node.data+ " "); //print after recursive call
            }
            //Check if node has left child
            else if ( node.left !=null) {
                
                printRightBoundary (node.left);
                System.out.println(node.data+ " ");//print after recursive call
            }
            //else do nothing. Otherwise it would print the leaf nodes.
        }
    }
    
    public void printLeafNodes ( Node node) {
        if ( node != null ) {
            printLeafNodes ( node.left);
            if ( node.left == null && node.right == null )
                System.out.println (node.data+" ");
            printLeafNodes ( node.right);
        }
    }
    
    public void printBoundary ( Node root) {
        
        System.out.println ( root.data + " ");
        
        printLeftBoundary(root.left );//print left boundary
        
        printLeafNodes( root.left);//print leaf nodes of left child
        printLeafNodes( root.right);//print leaf ndoe of right child
        
        printRightBoundary(root.right); //print right boundary
        
    }
    
    
    public static void main ( String [] args) {
        BSTBoundaryTraversal tree = new BSTBoundaryTraversal();
        
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
    }
    
    
}
