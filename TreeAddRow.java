// Leet Code problem : 623
//Given the root of a binary tree, then value v and depth d, you need to add
//a row of nodes with value v at the given depth d. The root node is at depth 1.

//The adding rule is: given a positive integer depth d, for each NOT null
//tree nodes N in depth d-1, create two tree nodes with value v as N's left
// subtree root and right subtree root. And N's original left subtree should
// be the left subtree of the new left subtree root, its original right
//subtree should be the right subtree of the new right subtree root. If depth
//d is 1 that means there is no depth d-1 at all, then create a tree node
//with value v as the new root of the whole original tree, and the original
//tree is the new root's left subtree.

//The soluton attempts BFS for level d-1. Then adds new nodes in place of children of the nodes of d-1 level. The children of nodes of d-1 level becomes children of newly inserted row.

import java.util.*;

public class TreeAddRow {
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
    public static int tilt;
    
    public void merge ( ArrayList <Integer> arr1, ArrayList<Integer> arr2, ArrayList <Integer> arr3 ){
        
    }
    
    public void inOrder ( Node root) {
        
        if ( root == null ) return;
        
        inOrder (root.left);
        System.out.print (root.data + " ");
        inOrder (root.right);
        
    }
    
    
    public void chngeNodes ( Node root, int v, int d) {
        
        if ( root == null ) return; // Do nothing
        
        if ( d == 1 ) {
            
            System.out.println("root.data = " + root.data +" ");
            
            Node tmp = root.left;
            root.left = new Node (v);
            root.left.left = tmp;
            
            tmp = root.right;
            root.right = new Node (v);
            root.right.right = tmp;
            
        }
        
        if (d > 1 ) {
            chngeNodes ( root.left, v, d-1);
            chngeNodes ( root.right, v, d-1);
        }
        
    }

    public static void main(String args[])
    {
        // Build the tree
        
        TreeAddRow tree = new TreeAddRow();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(1);
        tree.root.right.left = new Node(5);
        
        System.out.println ("Inorder Traversal of tree");
        tree.inOrder(tree.root);
        System.out.println ("");
        
        tree.chngeNodes ( tree.root, 1, 1);
        
        System.out.println ("Inorder Traversal of tree after inserting row");
        tree.inOrder(tree.root);
        System.out.println ("");
        
    }

}
