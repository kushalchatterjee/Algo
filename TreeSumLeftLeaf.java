// Given a Binary Tree find the sum of all leaf nodes 
// Steps for recursion :
//   IF node is null, return 0
//   Check for nodes left child being non-null, nodes left child's left and right child being null. If   so add the value of nodes left child.
//   Call recursion for left and right child, add values to their val.


import java.util.*;

public class TreeSumLeftLeaf {
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

    
    
    public int sumLeftTree (Node root) {
        
        int sum = 0;
        if ( root == null ) return 0;
        
        if ( root.left != null && root.left.right == null && root.left.right == null ) {
            sum += root.left.data;
        }
        
        return ( sum + sumLeftTree (root.left) + sumLeftTree (root.right));
        
    }
    

    // Driver Code

    public static void main(String args[])
    {
        // Build the tree
        TreeSumLeftLeaf tree = new TreeSumLeftLeaf();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);
        
 
        // head refers to the head of the Link List
        
        // Display the Circular LinkedList
        System.out.println ( "Sum of left leaf nodes " + tree.sumLeftTree(tree.root) );
    }

}
